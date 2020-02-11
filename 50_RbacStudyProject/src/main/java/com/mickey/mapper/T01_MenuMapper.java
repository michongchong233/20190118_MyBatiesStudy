package com.mickey.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T01_Menu;

public interface T01_MenuMapper {

	@Results(value= {
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "menu_name", property = "menuName"),
			@Result(column = "pid", property = "pid"),
			@Result(property = "children", many = @Many(select = "selectByPid"), column = "uid=uid,pid=id")
	})
	@Select("select *, #{uid} uid from rabc_01_menu where id in (" + //
			"select mid from rabc_01_user_menu where uid=#{uid}" + //
			") and pid=#{pid};" //
	)
	List<T01_Menu> selectByPid(Map<String, Object> map);
}
