package com.mickey.service;

import java.util.List;

import com.mickey.pojo.Menu;
import com.mickey.pojo.User;

public interface UserService {
	// �d�ߩҦ��Τ�
	public List<User> selectAllUser();

	// �إߥΤ�
	public int createUser(String username, String password);

	// �Τ�n�J
	public User doLogin(String username, String password);

	// �d�ߩҦ����
	public List<Menu> selectAllMenu();
	
	//�̷ӥΤ�s���d�ߵ��(�v��)
	public List<Menu> selectUserMenu(int uid);
	
	//�̷ӥΤ�s���d�ߵ��(�v���ARBAC)
	public List<Menu> selectUserMenuByRbac(int uid);
}
