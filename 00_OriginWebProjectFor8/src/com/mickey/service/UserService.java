package com.mickey.service;

import java.util.List;

import com.mickey.pojo.User;

public interface UserService {
	public List<User> selectAll();

	int createUser(String uname, String password, byte gender, int age);
	
}
