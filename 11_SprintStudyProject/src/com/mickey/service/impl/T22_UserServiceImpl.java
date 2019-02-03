package com.mickey.service.impl;

import org.springframework.stereotype.Component;

import com.mickey.mapper.T22_UserMapper;
import com.mickey.pojo.T22_User;
import com.mickey.service.T22_UserService;

public class T22_UserServiceImpl implements T22_UserService {
	private T22_UserMapper um;

	public T22_UserMapper getUm() {
		return um;
	}

	public void setUm(T22_UserMapper um) {
		this.um = um;
	}

	@Override
	public T22_User login(String uname, String password) {
		T22_User user = um.login(uname, password);
		return user;
	}

}
