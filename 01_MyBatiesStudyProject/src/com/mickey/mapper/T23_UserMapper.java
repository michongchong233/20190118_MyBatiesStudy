package com.mickey.mapper;

import java.util.List;

import com.mickey.pojo.User;

public interface T23_UserMapper {
	//查詢全部用戶
	public List<User> selectAll();
	
	//根據uid和uname查詢用戶
	public User selectById(int uid, String uname);
	
	public List<User> selectForDynamicSql_if(int uid, String uname, byte gender);
	
	public List<User> selectForDynamicSql_where(int uid, String uname, byte gender);

	public List<User> selectForDynamicSql_choose(int uid, String uname, byte gender);

	public int updateForDynamicSql_set(int uid, String uname, byte gender);

	public List<User> selectForDynamicSql_trim(int uid, String uname, byte gender);
	
	public int insertForDynamicSql_set(String uname, String password, byte gender, int age);
	
	//class 25，使用不同的select標簽就是屬於不同的statement
	public List<User> selectAll_Cache();
}
