package com.mickey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.MenuMapper;
import com.mickey.mapper.UserMapper;
import com.mickey.pojo.Menu;
import com.mickey.pojo.User;
import com.mickey.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;
	@Resource
	MenuMapper menuMapper;

	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	@Override
	public int createUser(String username, String password) {
		int createNum = 0;
		User user = userMapper.selectUserBy(0, username, null);
		if(user != null) {//用戶名無重覆才能建立新的用戶
			createNum = userMapper.insertUser(username, password);
		}
		return createNum;
	}

	@Override
	public User doLogin(String username, String password) {
		return userMapper.selectUserBy(0, username, password);
	}

	@Override
	public List<Menu> selectAllMenu() {
		return menuMapper.selectAllMenu();
	}

	@Override
	public List<Menu> selectUserMenu(int uid) {
		return menuMapper.selectUserMenu(uid);
	}

	@Override
	public List<Menu> selectUserMenuByRbac(int uid) {
		return menuMapper.selectUserMenuByRbac(uid);
	}

}
