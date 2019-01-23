package com.mickey.service;

import java.io.IOException;
import java.util.List;

import com.mickey.pojo.T20_PageInfo;
import com.mickey.pojo.User;

public interface T20_UserLimitPageService {
	public T20_PageInfo showUser(Integer pageStart, Integer pageSize) throws IOException;
	
	public int createUser(String uname, String password, byte gender, int age) throws IOException;
}
