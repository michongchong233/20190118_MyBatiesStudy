package com.mickey.dao;

import java.util.List;

import com.mickey.pojo.User;

public interface UserDao {
	public List<User> selectAll();

	int createUser(String uname, String password, byte gender, int age);
}
