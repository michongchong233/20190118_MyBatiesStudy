package com.mickey.pojo;

public class T04_Element {
	private int id;
	private String elementStr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElementStr() {
		return elementStr;
	}

	public void setElementStr(String elementStr) {
		this.elementStr = elementStr;
	}

	@Override
	public String toString() {
		return "T04_Element [id=" + id + ", elementStr=" + elementStr + "]";
	}

}
