package cn.gameboys.test;



public class Test {
	public void sayHi(String name) {
		User user = new User();
		user.setName(name);
		user.setUserID(667);
		System.out.println(user);

/*		Generator gen = new Generator();
		String result = gen.test("sniper");
		System.out.println(result);*/
	}

}
