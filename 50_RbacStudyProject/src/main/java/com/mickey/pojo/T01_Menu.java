package com.mickey.pojo;

import java.util.List;

public class T01_Menu {
	private int id;
	private String menuName;
	private int pid;
	private List<T01_Menu> children;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<T01_Menu> getChildren() {
		return children;
	}

	public void setChildren(List<T01_Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "T01_Menu [id=" + id + ", menuName=" + menuName + ", pid=" + pid + ", children=" + children + "]";
	}

}
