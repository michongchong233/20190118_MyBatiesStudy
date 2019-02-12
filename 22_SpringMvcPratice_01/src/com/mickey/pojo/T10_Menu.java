package com.mickey.pojo;

import java.util.List;

public class T10_Menu {
	private int id;
	private String name;
	private int pid;
	private List<T10_Menu> child;

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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<T10_Menu> getChild() {
		return child;
	}

	public void setChild(List<T10_Menu> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "T10_Menu [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}

}
