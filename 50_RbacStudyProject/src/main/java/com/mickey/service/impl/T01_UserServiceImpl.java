package com.mickey.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.T01_UserMapper;
import com.mickey.pojo.T01_User;
import com.mickey.service.T01_UserService;

@Service
public class T01_UserServiceImpl implements T01_UserService{
	@Resource
	private T01_UserMapper userMapper;

	@Override
	public T01_User logIn(T01_User user) {
		return userMapper.selectUser(user);
	}

}
