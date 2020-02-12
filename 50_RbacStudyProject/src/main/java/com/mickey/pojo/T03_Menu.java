package com.mickey.pojo;

import java.util.List;

public class T03_Menu {
	private int id;
	private String menuName;
	private int pid;
	private List<T03_Menu> menus;

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

	public List<T03_Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<T03_Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "T03_Menu [id=" + id + ", menuName=" + menuName + ", pid=" + pid + ", menus=" + menus + "]";
	}

}
