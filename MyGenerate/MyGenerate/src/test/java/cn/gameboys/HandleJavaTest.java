package cn.gameboys;

import cn.gameboys.util.FileUtil;

public class HandleJavaTest {

	public static void main(String[] args) {


		StringBuilder methodCode = FileUtil.readFileToString("D:/tmp/to/code.txt");

		StringBuilder sb2 = FileUtil.readFileToString("D:/workspace_v3/MyGenerate/src/main/java/cn/gameboys/test/MyGenerateHandler.java");

		String[] strArr = sb2.toString().split("\n");
		StringBuilder result = new StringBuilder();
		
		for (String string : strArr) {
			result.append(string).append("\n");
			if(string.startsWith("public class ")){
				result.append("	@Override").append("\n");
				result.append("	protected void resolveLogic() {").append("\n");
				result.append(methodCode).append("\n");
				result.append("	}").append("\n");
			}
		}
		
		System.out.println(result);

		FileUtil.createFile("D:\\tmp\\java\\cn\\gameboys\\test\\MyGenerateHandler.java", result.toString());
		
		
		
		

	}
}
