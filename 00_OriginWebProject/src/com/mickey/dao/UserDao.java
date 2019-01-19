package com.mickey.dao;

import java.util.ArrayList;

import com.mickey.pojo.User;

public interface UserDao {
	public ArrayList<User> selectAll();
	
	public int createUser();
}
