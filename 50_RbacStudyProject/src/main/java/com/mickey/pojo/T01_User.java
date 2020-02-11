package com.mickey.pojo;

import java.util.List;

public class T01_User {
	private int id;
	private String username;
	private String password;
	private List<T01_Menu> menus;

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

	public List<T01_Menu> getMenu() {
		return menus;
	}

	public void setMenu(List<T01_Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "T01_User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
