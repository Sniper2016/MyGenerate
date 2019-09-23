package cn.gameboys;

import cn.gameboys.base.DynamicCompilePathUtil;

public class CompliteTest {

	public static void main(String[] args) throws Exception {


		String classPath = ".;D:\\tmp\\loader\\generate.jar";

		String fromPath = "D:\\tmp\\java";
		String toPath = "D:\\tmp\\to";

		
		DynamicCompilePathUtil.dynamicCompileAFile(classPath, "D:\\tmp\\java\\cn\\gameboys\\test\\User.java", toPath);
		
		DynamicCompilePathUtil.dynamicCompileAFile(classPath, "D:\\tmp\\java\\cn\\gameboys\\test\\Test.java", toPath);

		
		DynamicCompilePathUtil.dynamicCompile(classPath, fromPath, toPath);
		System.out.println("dynamicCompile ok");
		
		

	/*	ClassPathClassLoader loader = new ClassPathClassLoader(classPath);
		Class clazz = null;
		try {
			clazz = loader.loadClass("cn.gameboys.test.Test");
			// clazz = loader.loadClass(servletName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Object obj = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				try {
					if (method.getName().equals("sayHi")) {
						method.invoke(obj, "lisa");
					}
				} catch (IllegalArgumentException | InvocationTargetException e) {

					e.printStackTrace();
				}
			}
			System.out.println(obj.getClass().getClassLoader());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println("run class ok");
		*/
		

	}
}
