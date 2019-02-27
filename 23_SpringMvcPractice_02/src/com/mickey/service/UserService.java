package com.mickey.service;

import java.util.List;

import com.mickey.pojo.User;

public interface UserService {
	// 琩高ノめ
	public List<User> selectAllUser();

	// ミノめ
	public int insertUser(User user);

	// 更ゅン(璶穝更Ω计)
	public int doDownloadFile(String photo);

	// ノめ祅
	public User doLogin(String username, String password);
}
