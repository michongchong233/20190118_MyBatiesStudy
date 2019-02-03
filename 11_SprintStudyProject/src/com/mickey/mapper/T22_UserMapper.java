package com.mickey.mapper;

import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T22_User;

public interface T22_UserMapper {
	@Select("select * from t41_userimformation where uname=#{param1} and password=#{param2}")
	public T22_User login(String uname, String password) ;
}
