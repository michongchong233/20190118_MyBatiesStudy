package com.mickey.mapper;

import java.util.List;

import com.mickey.pojo.User;

public interface T23_UserMapper {
	//�d�ߥ����Τ�
	public List<User> selectAll();
	
	//�ھ�uid�Muname�d�ߥΤ�
	public User selectById(int uid, String uname);
	
}
