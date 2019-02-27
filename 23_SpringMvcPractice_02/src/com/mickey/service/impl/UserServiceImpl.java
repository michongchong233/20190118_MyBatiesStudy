package com.mickey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.UserMapper;
import com.mickey.pojo.User;
import com.mickey.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;

	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	@Override
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public int doDownloadFile(String photo) {
		User user = userMapper.selectBy(0, null, null, photo);
		return userMapper.updateDownloadNum(user.getId(), user.getDownloadNum()+1);
	}

	@Override
	public User doLogin(String username, String password) {
		return userMapper.selectBy(0, username, password, null);
	}

	

	

}
