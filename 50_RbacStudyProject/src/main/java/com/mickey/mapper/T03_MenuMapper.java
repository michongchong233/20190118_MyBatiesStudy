package com.mickey.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T03_Menu;

public interface T03_MenuMapper {
	
	@Results(value= {
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "menu_name", property = "menuName"),
			@Result(column = "pid", property = "pid"),
			@Result(property = "menus", many = @Many(select = "selectByUid"), column = "uid=uid,pid=id")
	})
	@Select("select rbac_03_menu.*, #{uid} uid from rbac_03_actor_menu " + 
			"inner join rbac_03_menu on rbac_03_actor_menu.mid = rbac_03_menu.id " + 
			"where aid in(select aid from rbac_03_user_actor where uid=#{uid}) and pid=#{pid}")
	public List<T03_Menu> selectByUid(Map<String, Object> map);
	
}
