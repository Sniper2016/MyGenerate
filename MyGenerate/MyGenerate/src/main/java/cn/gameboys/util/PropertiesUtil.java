package cn.gameboys.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtil {
	private static Map<String, Properties> cfgMap = new HashMap<String, Properties>();
	private static Properties defPro = new Properties();

	public static Integer getAsInt(ResourceBundle cache, String key) {
		String strValue = cache.getString(key);
		if (strValue == null)
			return null;

		return Integer.valueOf(strValue.trim());
	}

	public static Integer getAsInt(ResourceBundle cache, String key, Integer defaultValue) {
		Integer value = null;
		try {
			value = getAsInt(cache, key);
		} catch (Exception e) {
		}
		return (value == null) ? defaultValue : value;
	}

	public static Boolean getAsBoolean(ResourceBundle cache, String key) {
		String value = cache.getString(key);
		if (value == null)
			return null;
		if (value.trim().compareToIgnoreCase("TRUE") == 0 || value.trim().compareToIgnoreCase("1") == 0)
			return true;
		else
			return false;
	}

	public static Boolean getAsBoolean(ResourceBundle cache, String key, boolean defaultValue) {
		Boolean value = null;
		try {
			value = getAsBoolean(cache, key);
		} catch (Exception e) {
		}
		return (value == null) ? defaultValue : value;
	}

	public static String getAsString(ResourceBundle cache, String key) {
		String strValue = cache.getString(key);
		if (strValue == null)
			return null;
		return strValue.trim();
	}

	public static String getAsString(ResourceBundle cache, String key, String defaultValue) {
		String value = null;
		try {
			value = getAsString(cache, key);
		} catch (Exception e) {
		}
		return (value == null) ? defaultValue : value;
	}

	// Properties
	public static Integer getAsInt(Properties cache, String key) {
		String strValue = cache.getProperty(key);
		if (strValue == null)
			return null;

		return Integer.valueOf(strValue.trim());
	}

	public static Integer getAsInt(Properties cache, String key, Integer defaultValue) {
		Integer value = null;
		try {
			value = getAsInt(cache, key);
		} catch (Exception e) {
		}
		return (value == null) ? defaultValue : value;
	}

	public static Boolean getAsBoolean(Properties cache, String key) {
		String value = cache.getProperty(key);
		if (value == null)
			return null;
		if (value.trim().compareToIgnoreCase("TRUE") == 0 || value.trim().compareToIgnoreCase("1") == 0)
			return true;
		else
			return false;
	}

	public static Boolean getAsBoolean(Properties cache, String key, boolean defaultValue) {
		Boolean value = null;
		try {
			value = getAsBoolean(cache, key);
		} catch (Exception e) {
		}
		return (value == null) ? defaultValue : value;
	}

	public static String getAsString(Properties cache, String key) {
		String strValue = cache.getProperty(key);
		if (strValue == null)
			return null;
		return strValue.trim();
	}

	public static String getAsString(Properties cache, String key, String defaultValue) {
		String value = null;
		try {
			value = getAsString(cache, key);
		} catch (Exception e) {
		}
		return (value == null) ? defaultValue : value;
	}

	public static Float getAsFloat(Properties cache, String key) {
		String strValue = cache.getProperty(key);
		if (strValue == null)
			return null;

		return Float.valueOf(strValue.trim());
	}

	public static Float getAsFloat(Properties cache, String key, Float defaultValue) {
		Float value = null;
		try {
			value = getAsFloat(cache, key);
		} catch (Exception e) {
		}
		return (value == null) ? defaultValue : value;
	}

	public static String getRootPath() {
		String rootPath = PropertiesUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		int pos = rootPath.lastIndexOf("/");
		rootPath = rootPath.substring(0, pos + 1);
		return rootPath;
	}

	public static void readCfg(String pathOrName) {
		if (cfgMap.containsKey(pathOrName))
			return;
		// Properties pro = new Properties();
		try {
			defPro.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(pathOrName), "UTF-8"));
			//defPro.load(new FileInputStream(pathOrName,"UTF-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties getDefPro() {
		return defPro;
	}
}
