package com.mickey.service;

import java.util.List;

import com.mickey.pojo.Menu;
import com.mickey.pojo.User;

public interface UserService {
	// 查詢所有用戶
	public List<User> selectAllUser();

	// 建立用戶
	public int createUser(String username, String password);

	// 用戶登入
	public User doLogin(String username, String password);

	// 查詢所有菜單
	public List<Menu> selectAllMenu();
	
	//依照用戶編號查詢菜單(權限)
	public List<Menu> selectUserMenu(int uid);
	
	//依照用戶編號查詢菜單(權限，RBAC)
	public List<Menu> selectUserMenuByRbac(int uid);
}
