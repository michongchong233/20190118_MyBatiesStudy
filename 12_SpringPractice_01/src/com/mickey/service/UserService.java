package com.mickey.service;

import com.mickey.mapper.UserMapper;
import com.mickey.pojo.User;

public interface UserService {

	// 檢查輸入的帳號、密碼是否有對應一個用戶
	public User loginSelect(String uname, String password);
	
	public UserMapper getUserMapper();
	
	public void setUserMapper(UserMapper userMapper);

}
