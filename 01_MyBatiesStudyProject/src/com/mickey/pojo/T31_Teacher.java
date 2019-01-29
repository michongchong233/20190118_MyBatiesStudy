package com.mickey.pojo;

import java.util.List;

public class T31_Teacher {
	private int tid;
	private String tname;
	private List<T31_Student> student;

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

	public List<T31_Student> getStudent() {
		return student;
	}

	public void setStudent(List<T31_Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "T31_Teacher [tid=" + tid + ", tname=" + tname + ", student=" + student + "]";
	}

}
