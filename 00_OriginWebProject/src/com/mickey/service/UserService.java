package com.mickey.service;

import java.util.ArrayList;

import com.mickey.pojo.User;

public interface UserService {
	public ArrayList<User> selectAll();
	
	public int createUser();
	
}
