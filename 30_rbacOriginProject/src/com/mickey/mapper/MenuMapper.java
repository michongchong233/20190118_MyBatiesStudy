package com.mickey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.Menu;

public interface MenuMapper {
	@Select("select * from t10_menu")
	public List<Menu> selectAllMenu();
	
	public List<Menu> selectUserMenu(int uid);
	
	public List<Menu> selectUserMenuByRbac(int uid);

}
