package com.mickey.pojo;

public class User {
	private int uid;
	private String uname;
	private String password;
	private byte gender;
	private int age;

	public int getId() {
		return uid;
	}

	public void setId(int id) {
		this.uid = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + uid + ", uname=" + uname + ", password=" + password + ", gender=" + gender + ", age=" + age
				+ "]";
	}

	public User(int id, String uname, String password, byte gender, int age) {
		super();
		this.uid = id;
		this.uname = uname;
		this.password = password;
		this.gender = gender;
		this.age = age;
	}

	public User() {
		super();
	}

}
