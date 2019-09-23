package cn.gameboys.test;

import cn.gameboys.util.FileUtil;

public class HandleJavaTest {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		sb.append("	@Override").append("\n");
		sb.append("	protected void resolveLogic() {").append("\n");
		sb.append("		println(t.getId());").append("\n");
		sb.append("		println(t.getIntList());").append("\n");
		sb.append("		for (int i = 0; i < 20; i++) {").append("\n");
		sb.append("			print(i + \" \");").append("\n");
		sb.append("			println(\"sniper\");").append("\n");
		sb.append("		}").append("\n");
		sb.append("	}").append("\n");
		
		
		
		StringBuilder sb2 = FileUtil.readFileToString("D:/workspace_v3/MyGenerate/src/main/java/cn/gameboys/test/MyGenerateHandler.java");

		String[] strArr = sb2.toString().split("\n");
		StringBuilder result = new StringBuilder();
		
		for (String string : strArr) {
			result.append(string).append("\n");
			if(string.startsWith("public class ")){
				result.append(sb).append("\n");
			}
		}
		
		System.out.println(result);

		FileUtil.createFile("D:\\tmp\\java\\cn\\gameboys\\test\\MyGenerateHandler.java", result.toString());
		
		
		
		

	}
}
