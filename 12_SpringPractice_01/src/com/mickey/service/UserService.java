package com.mickey.service;

import com.mickey.mapper.UserMapper;
import com.mickey.pojo.User;

public interface UserService {

	// �ˬd��J���b���B�K�X�O�_�������@�ӥΤ�
	public User loginSelect(String uname, String password);
	
	public UserMapper getUserMapper();
	
	public void setUserMapper(UserMapper userMapper);

}
