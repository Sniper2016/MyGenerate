package cn.gameboys.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtil {

	/**
	 * 创建一个文件
	 * 
	 * @param fileName
	 *            文件全路径名
	 * @param content
	 *            内容
	 */
	public static void createFile(String fileName, String content) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out.write(content);
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * 读取一个字符串文件，返回字符串，
	 * 
	 * @param fileName
	 * @return
	 */
	public static StringBuilder readFileToString(String fileName) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String line = "";
		try {
			line = in.readLine();
			while (line != null) {
				sb.append(line).append("\n");
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb;
	}


}
