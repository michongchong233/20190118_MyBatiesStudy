package com.mickey.pojo;

public class T04_Person {
	private int id;
	private String name;

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

	@Override
	public String toString() {
		return "T04_Person [id=" + id + ", name=" + name + "]";
	}

	public T04_Person(int id, String name) {
		super();
		System.out.println("�ե�T04_Person���Ѻc�y��k");
		this.id = id;
		this.name = name;
	}

	public T04_Person() {
		super();
		System.out.println("�ե�T04_Person�L�Ѻc�y��k");
	}

}
