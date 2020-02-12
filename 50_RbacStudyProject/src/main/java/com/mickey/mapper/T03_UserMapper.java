package com.mickey.mapper;

import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T03_User;

public interface T03_UserMapper {
	
	@Select("select *,0 pid from rbac_03_user where username=#{username} and password=#{password}")
	public T03_User selectByLogin(T03_User user);
	
}
