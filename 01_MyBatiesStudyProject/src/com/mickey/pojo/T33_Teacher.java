package com.mickey.pojo;

public class T33_Teacher {
	private int tid;
	private String tname;
	private T31_Student student;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public T31_Student getStudent() {
		return student;
	}

	public void setStudent(T31_Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "T33_Teacher [tid=" + tid + ", tname=" + tname + ", student=" + student + "]";
	}

}
