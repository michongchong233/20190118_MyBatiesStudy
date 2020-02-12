package com.mickey.pojo;

import java.util.List;

public class T03_User {
	private int id;
	private String username;
	private String password;
	private List<T03_Menu> menus;
	private List<T04_Element> elements;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<T03_Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<T03_Menu> menus) {
		this.menus = menus;
	}

	public List<T04_Element> getElement() {
		return elements;
	}

	public void setElement(List<T04_Element> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "T03_User [id=" + id + ", username=" + username + ", password=" + password + ", menus=" + menus
				+ ", element=" + elements + "]";
	}

}
