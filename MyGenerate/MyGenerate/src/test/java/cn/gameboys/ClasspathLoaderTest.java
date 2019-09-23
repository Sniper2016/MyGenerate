package cn.gameboys;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.gameboys.base.ClassPathClassLoader;

public class ClasspathLoaderTest {

	public static void main(String[] args) {

		String classPath = "D:\\tmp\\loader";

		ClassPathClassLoader loader = new ClassPathClassLoader(classPath);

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

		
		

	}

}
