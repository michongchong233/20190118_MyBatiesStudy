package com.mickey.mapper;

import java.util.List;

import com.mickey.pojo.User;

public interface T23_UserMapper {
	//查詢全部用戶
	public List<User> selectAll();
	
	//根據uid和uname查詢用戶
	public User selectById(int uid, String uname);
	
}
