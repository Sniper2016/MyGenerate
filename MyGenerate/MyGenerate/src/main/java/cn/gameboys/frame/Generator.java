package cn.gameboys.frame;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.gameboys.base.ClassPathClassLoader;
import cn.gameboys.base.DynamicCompilePathUtil;
import cn.gameboys.util.FileUtil;
import cn.gameboys.util.PropertiesUtil;

/**
 * 代码组装和编译，执行的逻辑类
 * 
 * @Description:
 * @author: sniper(1084038709@qq.com)
 * @date:2019年9月18日 下午5:41:24
 */
public class Generator {

	public String runMethodCode(String methodCode) {
		String basePath = PropertiesUtil.getAsString(PropertiesUtil.getDefPro(), "BasePath");
		// 全路径
		String handlerClassFullPath = PropertiesUtil.getAsString(PropertiesUtil.getDefPro(), "HandlerClassFullPath");
		String[] arr = handlerClassFullPath.split("\\.");
		String handlerName = arr[arr.length - 1];
		String handlerPackage = handlerClassFullPath.substring(0, handlerClassFullPath.length() - handlerName.length() - 1);

		this.buildJaveFile(basePath, handlerName, methodCode);
		this.complieFile(basePath, handlerName);
		return this.runFile(basePath, handlerName, handlerPackage);
	}

	private void buildJaveFile(String basePath, String handleName, String methodCode) {
		StringBuilder sb2 = FileUtil.readFileToString(basePath + "\\" + handleName + ".java");
		String[] strArr = sb2.toString().split("\n");
		StringBuilder result = new StringBuilder();
		for (String string : strArr) {
			result.append(string).append("\n");
			if (string.startsWith("public class ")) {
				result.append("	@Override").append("\n");
				result.append("	protected void resolveLogic() {").append("\n");
				result.append(methodCode).append("\n");
				result.append("	}").append("\n");
			}
		}
		
		boolean debug = PropertiesUtil.getAsBoolean(PropertiesUtil.getDefPro(), "Debug");
		if(debug){
			System.out.println(result.toString());
		}
		FileUtil.createFile(basePath + "\\classpath\\" + handleName + ".java", result.toString());
	}

	private void complieFile(String basePath, String handlerName) {

		StringBuilder runClassPath = new StringBuilder();
		runClassPath.append(":");
		File[] files = new File(basePath + "\\lib").listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(".jar")) {
					String path = file.getAbsolutePath();
					runClassPath.append(";" + path);
				}
			}
		}
		boolean debug = PropertiesUtil.getAsBoolean(PropertiesUtil.getDefPro(), "Debug");
		if(debug){
			System.out.println("runClassPath:"+runClassPath.toString());
		}
		DynamicCompilePathUtil.dynamicCompileAFile(runClassPath.toString(), basePath + "\\classpath\\" + handlerName + ".java", basePath + "\\classpath");
	}

	private String runFile(String basePath, String handleName, String handlerPackage) {
		String result = "";
		ClassPathClassLoader loader = new ClassPathClassLoader(basePath + "\\classpath");
		Class clazz = null;
		try {
			// System.out.println(handlerPackage + "." + handleName);
			clazz = loader.loadClass(handlerPackage + "." + handleName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Object obj = clazz.newInstance();
			// System.out.println("obj:" + obj);
			Method[] methods = clazz.getMethods();
			// 先初始化
			for (Method method : methods) {
				try {
					if (method.getName().equals("init")) {
						method.invoke(obj);
					}
				} catch (IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			// 再执行逻辑
			for (Method method : methods) {
				try {
					if (method.getName().equals("resolve")) {
						result = (String) method.invoke(obj);
					}
				} catch (IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			// System.out.println(obj.getClass().getClassLoader());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;

	}

}
