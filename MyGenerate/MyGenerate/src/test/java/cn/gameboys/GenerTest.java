package cn.gameboys;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.gameboys.base.ClassPathClassLoader;
import cn.gameboys.base.DynamicCompilePathUtil;

public class GenerTest {

	public static void main(String[] args) {
	
		String complieClassPath = "D:\\tmp\\java";
		String complieToPath = "D:\\tmp\\to";
		DynamicCompilePathUtil.dynamicCompile(complieClassPath,complieToPath, complieToPath);
		
		
		String classPath = "D:\\tmp\\to";
		ClassPathClassLoader loader = new ClassPathClassLoader(classPath);
		Class clazz = null;
		try {
			clazz = loader.loadClass("cn.gameboys.test.Test");
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
