package com.mickey.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_t05_student")
public class T06_Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<T06_Course> courses;

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

	public Set<T06_Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<T06_Course> courses) {
		this.courses = courses;
	}

	public T06_Student(int sid, String sname, Set<T06_Course> courses) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.courses = courses;
	}

	public T06_Student() {
		super();
		courses = new HashSet<T06_Course>();
	}

}
