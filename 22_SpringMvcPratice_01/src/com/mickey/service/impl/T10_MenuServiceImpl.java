package com.mickey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.mickey.mapper.T10_MenuMapper;
import com.mickey.pojo.T10_Menu;
import com.mickey.service.T10_MenuService;

public class T10_MenuServiceImpl implements T10_MenuService {
	@Resource
	public T10_MenuMapper menuMapper;
	
	@Override
	public List<T10_Menu> shwoMenu() {
		return menuMapper.selectById(0);
	}

}
