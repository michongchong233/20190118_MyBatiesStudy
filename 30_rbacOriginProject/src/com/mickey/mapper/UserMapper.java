package com.mickey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.User;

public interface UserMapper {

	@Select("select * from springmvc_t15_user")
	public List<User> selectAllUser();

	@Insert("insert into springmvc_t15_user values(default, #{param1}, #{param2}, default, default)")
	public int insertUser(String username, String password);

	public User selectUserBy(int id, String username, String password);

}
