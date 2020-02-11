package com.mickey.mapper;

import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T01_User;

public interface T01_UserMapper {
	
	@Select("select * from rabc_01_user where username=#{username} and password=#{password}")
	public T01_User selectUser(T01_User user);

}
