package com.mickey.service.impl;

import com.mickey.mapper.UserMapper;
import com.mickey.pojo.User;
import com.mickey.service.UserService;

public class UserServiceImpl implements UserService {
	UserMapper userMapper;
	
	@Override
	public User loginSelect(String uname, String password) {
		return userMapper.loginSelect(uname, password);
	}

	@Override
	public UserMapper getUserMapper() {
		return this.userMapper;
	}

	@Override
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
