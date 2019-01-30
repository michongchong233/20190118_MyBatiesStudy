package com.mickey.pojo;

public class T08_Student {
	private int id;
	private String name;
	private int age;
	private int tid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "T08_Student [id=" + id + ", name=" + name + ", age=" + age + ", tid=" + tid + "]";
	}

	public T08_Student(int id, String name, int age, int tid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.tid = tid;
	}

	public T08_Student() {
		super();
	}

}
