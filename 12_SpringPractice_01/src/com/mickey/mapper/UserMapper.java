package com.mickey.mapper;

import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.User;

public interface UserMapper {
	
	@Select("select uid, uname, password, gender, age " + 
			"from t41_userimformation " + 
			"where uname=#{param1} and password=#{param2}")
	public User loginSelect(String uname, String password);
	
}
