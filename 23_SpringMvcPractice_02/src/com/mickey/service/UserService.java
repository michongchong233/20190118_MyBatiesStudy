package com.mickey.service;

import java.util.List;

import com.mickey.pojo.User;

public interface UserService {
	public List<User> selectAllUser();

	public int insertUser(User user);
	
	public int doDownloadFile(String photo);
}
