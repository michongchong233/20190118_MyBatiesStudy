package com.mickey.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.T03_UserMapper;
import com.mickey.pojo.T03_User;
import com.mickey.service.T03_UserService;

@Service
public class T03_UserServiceImpl implements T03_UserService {
	@Resource
	T03_UserMapper mapper;

	@Override
	public T03_User login(T03_User user) {
		return mapper.selectByLogin(user);
	}

}
