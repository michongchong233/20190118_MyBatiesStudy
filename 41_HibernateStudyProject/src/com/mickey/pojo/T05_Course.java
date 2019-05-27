package com.mickey.pojo;

import java.util.HashSet;
import java.util.Set;

public class T05_Course {
	private int cid;
	private String cname;
	private Set<T05_Student> students;

	public void addStudent(T05_Student student) {
		students.add(student);
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<T05_Student> getStudents() {
		return students;
	}

	public void setStudents(Set<T05_Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "T05_Course [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}

	public T05_Course(int cid, String cname, Set<T05_Student> students) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.students = students;
	}

	public T05_Course() {
		super();
		students = new HashSet<T05_Student>();
	}

}
