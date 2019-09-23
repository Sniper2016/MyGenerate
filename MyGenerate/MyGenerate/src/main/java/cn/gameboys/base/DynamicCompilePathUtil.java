package cn.gameboys.base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 动态编译某个路径下的所有java类到指定目录下
 * 
 * @Description:
 * @author: sniper(1084038709@qq.com)
 * @date:2019年9月16日 上午10:32:27
 */
public class DynamicCompilePathUtil {

	/**
	 * 将该目录下的所有java文件解析成class文件
	 * 
	 * @param classPath
	 *            编译时候的classpath地址，需要的引用需要放到里面，不然编译找不到
	 * @param fromPath
	 * @param toPath
	 */
	public static void dynamicCompile(String classPath, String fromPath, String toPath) {
		File[] files = new File(fromPath).listFiles();
		if (files != null) {
			for (File file : files) {
				scanJavaFile(file, classPath, toPath);
			}
		}
	}

	/**
	 * 动态编译一个java文件
	 * @param classPath
	 * @param filePath
	 * @param toPath
	 */
	public static void dynamicCompileAFile(String classPath, String filePath, String toPath) {
			compileJavaFile(filePath, classPath, toPath);
	}

	
	private static void scanJavaFile(File file, String classPath, String toPath) {
		if (file.exists()) {
			if (file.isFile() && file.getName().endsWith(".java")) {
				String path = file.getAbsolutePath();
				System.out.println(path);
				compileJavaFile(path, classPath, toPath);
			} else if (file.isDirectory()) {
				for (File f : file.listFiles()) {
					scanJavaFile(f, classPath, toPath);
				}
			}
		}
	}

	private static void compileJavaFile(String filePath, String classPath, String toPath) {
		StandardJavaFileManager sjf = null;
		try {
			JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
			Iterable<String> options = Arrays.asList("-classpath", classPath, "-d", toPath);
			sjf = complier.getStandardFileManager(null, null, null);
			Iterable it = sjf.getJavaFileObjects(filePath);
			CompilationTask task = complier.getTask(null, sjf, null, options, null, it);
			task.call(); // 调用创建
		} finally {
			try {
				sjf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
