package com.mickey.service;

import java.util.List;

import com.mickey.pojo.User;

public interface UserService {
	// �d�ߥΤ�C��
	public List<User> selectAllUser();

	// �إߥΤ�
	public int insertUser(User user);

	// �U�����(�D�n��s�U������)
	public int doDownloadFile(String photo);

	// �Τ�n�J
	public User doLogin(String username, String password);
}
