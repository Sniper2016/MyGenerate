package cn.gameboys.test;

public class User {

	private int userID;
	private String name;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + "]";
	}

}
