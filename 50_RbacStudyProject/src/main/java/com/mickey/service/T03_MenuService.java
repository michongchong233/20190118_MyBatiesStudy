package com.mickey.service;

import java.util.List;

import com.mickey.pojo.T03_Menu;

public interface T03_MenuService {
	public List<T03_Menu> getUserMenu(int uid);
}
