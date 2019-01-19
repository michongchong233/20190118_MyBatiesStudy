package com.mickey.service.impl;

import java.util.List;

import com.mickey.dao.impl.UserDaoImpl;
import com.mickey.pojo.User;
import com.mickey.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Override
	public List<User> selectAll() {
		List<User> userList =  new UserDaoImpl().selectAll();
		return userList;
	}

	@Override
	public int createUser(String uname, String password, byte gender, int age) {
		int updateNum = new UserDaoImpl().createUser(uname, password, gender, age);
		return updateNum;
	}

}
