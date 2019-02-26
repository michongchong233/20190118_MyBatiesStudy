package com.mickey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mickey.pojo.User;

public interface UserMapper {
	@Select("select * from springmvc_t15_user;")
	public List<User> selectAllUser();

	@Insert("insert into springmvc_t15_user values (default, #{username}, #{password}, #{photo}, default);")
	public int insertUser(User user);

	@Select("select * from springmvc_t15_user where photo=#{param1}")
	public User selectUserByPhoto(String photo);

	@Update("update springmvc_t15_user set downloadNum=#{param2} where id=#{param1};")
	public int updateDownloadNum(int id, int downloadNum);
}
