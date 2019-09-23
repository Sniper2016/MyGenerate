package cn.gameboys.frame;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import cn.gameboys.util.FileUtil;
import cn.gameboys.util.PropertiesUtil;

/**
 * 将脚本目录下的work目录下的所有以.j结尾的所有文件中包含的java代码解析
 * 
 * @Description:
 * @author: sniper(1084038709@qq.com)
 * @date:2019年9月18日 下午4:30:37
 */
public class TempleResolveManager {

	public static final String PREFIX_METHOD_CODE = "<@@@@@@";// 前缀
	public static final String SUFFIX_METHOD_CODE = "@@@@@@>";// 后缀

	private Generator generator;

	public TempleResolveManager() {
		this.generator = new Generator();
	}

	public void resolve() {
		String basePath = PropertiesUtil.getAsString(PropertiesUtil.getDefPro(), "BasePath");
		File[] files = new File(basePath + "\\work").listFiles();
		if (files != null) {
			for (File file : files) {
				resolveAFile(file);
			}
		}
	}

	/**
	 * 解析一个文件
	 * 
	 * @param file
	 */
	private void resolveAFile(File file) {
		// 只处理文件，文件夹不管
		if (file.exists()) {
			if (file.isFile() && file.getName().endsWith(".j")) {
				// 理论上需要检查一下代码标识是否一一对应等等，
				try {
					System.out.println("resolve j file:" + file.getAbsolutePath());
					List<String> list = Files.readAllLines(Paths.get(file.getAbsolutePath()));
					StringBuilder resultSB = new StringBuilder();
					StringBuilder methodCode = new StringBuilder();
					boolean inMethodCode = false;
					for (String str : list) {
						// 最先考虑前缀后缀在一行的情况 aaa<@@@@@@ 7777 @@@@@@>bbbb
						int bIndex = str.indexOf(PREFIX_METHOD_CODE);
						int eIndex = str.indexOf(SUFFIX_METHOD_CODE);
						if (bIndex >= 0 && eIndex >= 0) {
							// aaa<@@@@@@ code @@@@@@> bbb
							methodCode = new StringBuilder();
							String beginStr = str.substring(0, bIndex);
							if (beginStr.length() > 0) {
								resultSB.append(beginStr);
							}
							//
							String methodStr = str.substring(beginStr.length() + PREFIX_METHOD_CODE.length(), eIndex);
							methodCode.append(methodStr);
							resultSB.append(generator.runMethodCode(methodCode.toString()));
							if (str.length() > beginStr.length() + methodStr.length() + PREFIX_METHOD_CODE.length() + SUFFIX_METHOD_CODE.length()) {
								// 有结尾
								String endStr = str.substring(eIndex + SUFFIX_METHOD_CODE.length(), str.length());
								resultSB.append(endStr).append("\n");
							} else {
								resultSB.append("\n");
							}
							continue;
						}
						// 处理了所有6种可能 aaa<@@@@@@ 7777 @@@@@@>bbbb
						// 考虑前缀
						int index = str.indexOf(PREFIX_METHOD_CODE);
						if (index >= 0) {
							inMethodCode = true;
							methodCode = new StringBuilder();
							String beginStr = str.substring(0, index);
							if (beginStr.length() > 0) {
								resultSB.append(beginStr);
							}
							if (str.length() > beginStr.length() + PREFIX_METHOD_CODE.length()) {
								// 有结尾
								String endStr = str.substring(beginStr.length() + PREFIX_METHOD_CODE.length(), str.length());
								methodCode.append(endStr);
							}
							continue;
						}
						// 考虑后缀
						index = str.indexOf(SUFFIX_METHOD_CODE);
						if (index >= 0) {
							String beginStr = str.substring(0, index);
							if (beginStr.length() > 0) {
								methodCode.append(beginStr);
							}
							inMethodCode = false;
							resultSB.append(generator.runMethodCode(methodCode.toString()));
							if (str.length() > beginStr.length() + SUFFIX_METHOD_CODE.length()) {
								// 有结尾
								String endStr = str.substring(beginStr.length() + SUFFIX_METHOD_CODE.length(), str.length());
								resultSB.append(endStr).append("\n");
							} else {
								resultSB.append("\n");
							}
							continue;
						}

						if (inMethodCode) {
							methodCode.append(str).append("\n");
						} else {
							resultSB.append(str).append("\n");
						}
					}
					FileUtil.createFile(file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - 2), resultSB.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
