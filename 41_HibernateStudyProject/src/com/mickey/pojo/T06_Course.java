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
@Table(name = "hibernate_t05_course")
public class T06_Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<T06_Student> students;

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

	public Set<T06_Student> getStudents() {
		return students;
	}

	public void setStudents(Set<T06_Student> students) {
		this.students = students;
	}

	public T06_Course(int cid, String cname, Set<T06_Student> students) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.students = students;
	}

	public T06_Course() {
		super();
		students = new HashSet<T06_Student>();
	}

}
