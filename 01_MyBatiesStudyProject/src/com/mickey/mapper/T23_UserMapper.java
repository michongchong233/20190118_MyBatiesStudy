package com.mickey.mapper;

import java.util.List;

import com.mickey.pojo.User;

public interface T23_UserMapper {
	//�d�ߥ����Τ�
	public List<User> selectAll();
	
	//�ھ�uid�Muname�d�ߥΤ�
	public User selectById(int uid, String uname);
	
	public List<User> selectForDynamicSql_if(int uid, String uname, byte gender);
	
	public List<User> selectForDynamicSql_where(int uid, String uname, byte gender);

	public List<User> selectForDynamicSql_choose(int uid, String uname, byte gender);

	public int updateForDynamicSql_set(int uid, String uname, byte gender);

	public List<User> selectForDynamicSql_trim(int uid, String uname, byte gender);
	
	public int insertForDynamicSql_set(String uname, String password, byte gender, int age);
	
	//class 25�A�ϥΤ��P��select��ñ�N�O�ݩ󤣦P��statement
	public List<User> selectAll_Cache();
}
