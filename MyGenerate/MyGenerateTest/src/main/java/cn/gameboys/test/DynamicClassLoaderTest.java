package cn.gameboys.test;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class DynamicClassLoaderTest {
	public static void main(String[] args) {
		loadFile();
		//loadJar();
	}

	public static void loadFile() {
		URLClassLoader loader = null;
		try {
			URL[] urls = new URL[2];
			URLStreamHandler streamHandler = null;
			File classPath = new File("D:\\tmp\\loader");
			String repository1 = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
			
			
			URL url = new URL("file:" + "D:\\tmp\\loader\\generate.jar");
			String repository2 = (url).toString();

			
			urls[0] = new URL(null, repository1, streamHandler);
			urls[1] = new URL(null, repository2, streamHandler);
			loader = new URLClassLoader(urls);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	
	

	public static void loadJar() {
		String path = "D:\\tmp\\generate.jar";// 外部jar包的路径
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();// 所有的Class对象
		Map<Class<?>, Annotation[]> classAnnotationMap = new HashMap<Class<?>, Annotation[]>();// 每个Class对象上的注释对象
		Map<Class<?>, Map<Method, Annotation[]>> classMethodAnnoMap = new HashMap<Class<?>, Map<Method, Annotation[]>>();// 每个Class对象中每个方法上的注释对象
		try {
			JarFile jarFile = new JarFile(new File(path));
			URL url = new URL("file:" + path);
			ClassLoader loader = new URLClassLoader(new URL[] { url });// 自己定义的classLoader类，把外部路径也加到load路径里，使系统去该路经load对象
			Enumeration<JarEntry> es = jarFile.entries();
			while (es.hasMoreElements()) {
				JarEntry jarEntry = (JarEntry) es.nextElement();
				String name = jarEntry.getName();
				if (name != null && name.endsWith(".class")) {// 只解析了.class文件，没有解析里面的jar包
					// 默认去系统已经定义的路径查找对象，针对外部jar包不能用
					// Class<?> c =
					// Thread.currentThread().getContextClassLoader().loadClass(name.replace("/",
					// ".").substring(0,name.length() - 6));
					Class<?> c = loader.loadClass(name.replace("/", ".").substring(0, name.length() - 6));// 自己定义的loader路径可以找到
					System.out.println(c);
					classes.add(c);
					Annotation[] classAnnos = c.getDeclaredAnnotations();
					classAnnotationMap.put(c, classAnnos);
					Method[] classMethods = c.getDeclaredMethods();
					Map<Method, Annotation[]> methodAnnoMap = new HashMap<Method, Annotation[]>();
					for (int i = 0; i < classMethods.length; i++) {
						Annotation[] a = classMethods[i].getDeclaredAnnotations();
						methodAnnoMap.put(classMethods[i], a);
					}
					classMethodAnnoMap.put(c, methodAnnoMap);
				}
			}
			System.out.println(classes.size());
			
			
/*			try {
				URL[] urls = new URL[1];
				URLStreamHandler streamHandler = null;
				File classPath = new File("D:\\tmp");
				String repository1 = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();

				urls[0] = new URL(null, repository1, streamHandler);
				
				
		
				loader = new URLClassLoader(urls);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}*/
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	
		
		
		
		
		
		
		
	}

}
