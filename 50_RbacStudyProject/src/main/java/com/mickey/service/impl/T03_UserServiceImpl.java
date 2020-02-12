package com.mickey.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.T03_UserMapper;
import com.mickey.pojo.T03_User;
import com.mickey.service.T03_MenuService;
import com.mickey.service.T03_UserService;
import com.mickey.service.T04_ElementService;

@Service
public class T03_UserServiceImpl implements T03_UserService {
	@Resource
	T03_UserMapper userMapper;

	@Resource
	T03_MenuService menuService;
	
	@Resource
	T04_ElementService elementService;

	@Override
	public T03_User login(T03_User user) {
		T03_User searchUser = userMapper.selectByLogin(user);
		if(searchUser != null) {
			//取得菜單列表
			searchUser.setMenus(menuService.getUserMenu(searchUser.getId()));
			//取得頁面元素列表
			searchUser.setElement(elementService.getElementList(searchUser.getId()));
		}
		return searchUser;
	}

}
