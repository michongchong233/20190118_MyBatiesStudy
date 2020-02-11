package com.mickey.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T01_User;

public interface T01_UserMapper {
	
	@Results(value={
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "username", property = "username"),
			@Result(column = "password", property = "password"),
			@Result(property = "menus", many = @Many(select="com.mickey.mapper.T01_MenuMapper.selectByPid"), column = "uid=id,pid=pid")
	})
	//如果需要多個參數：column="{value01=列名01,value02=列名02}"，mybatis會將傳入的參數轉為map
	@Select("select *, 0 pid from rabc_01_user where username=#{username} and password=#{password}")
	public T01_User selectUser(T01_User user);

}
