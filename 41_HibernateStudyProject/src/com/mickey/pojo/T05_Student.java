package com.mickey.pojo;

import java.util.HashSet;
import java.util.Set;

public class T05_Student {
	private int sid;
	private String sname;
	private Set<T05_Course> courses;

	public void addCource(T05_Course course) {
		courses.add(course);
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<T05_Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<T05_Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "T05_Student [sid=" + sid + ", sname=" + sname + ", courses=" + courses + "]";
	}

	public T05_Student(int sid, String sname, Set<T05_Course> courses) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.courses = courses;
	}

	public T05_Student() {
		super();
		courses = new HashSet<T05_Course>();
	}

}
