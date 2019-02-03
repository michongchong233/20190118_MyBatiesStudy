package com.mickey.pojo;

public class T23_Person {
	private String name;
	private T23_Goods t23_Goods;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T23_Goods getT23_Goods() {
		return t23_Goods;
	}

	public void setT23_Goods(T23_Goods t23_Goods) {
		this.t23_Goods = t23_Goods;
	}

	@Override
	public String toString() {
		return "T23_Person [name=" + name + ", t23_Goods=" + t23_Goods + "]";
	}

}
