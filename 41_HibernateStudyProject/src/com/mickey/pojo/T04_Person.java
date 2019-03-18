package com.mickey.pojo;

public class T04_Person {
	private int id;
	private String name;
	private T04_Address address;

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

	public T04_Address getAddress() {
		return address;
	}

	public void setAddress(T04_Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "T04_Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	public T04_Person(int id, String name, T04_Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public T04_Person() {
		super();
	}

}
