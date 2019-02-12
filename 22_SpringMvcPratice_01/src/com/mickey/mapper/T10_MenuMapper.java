package com.mickey.mapper;

import java.util.List;

import com.mickey.pojo.T10_Menu;

public interface T10_MenuMapper {
	public List<T10_Menu> selectById(int pid);

}
