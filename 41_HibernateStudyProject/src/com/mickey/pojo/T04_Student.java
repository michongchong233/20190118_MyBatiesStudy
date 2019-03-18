package com.mickey.pojo;

public class T04_Student {
	private T04_StudentId columnKey;
	private String major;

	public T04_StudentId getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(T04_StudentId columnKey) {
		this.columnKey = columnKey;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "T04_Student [columnKey=" + columnKey + ", major=" + major + "]";
	}

	public T04_Student(T04_StudentId columnKey, String major) {
		super();
		this.columnKey = columnKey;
		this.major = major;
	}

	public T04_Student() {
		super();
	}

}
