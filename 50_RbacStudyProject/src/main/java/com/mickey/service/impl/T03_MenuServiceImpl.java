package com.mickey.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.T03_MenuMapper;
import com.mickey.pojo.T03_Menu;
import com.mickey.service.T03_MenuService;

@Service
public class T03_MenuServiceImpl implements T03_MenuService{
	
	@Resource
	T03_MenuMapper menuMapper; 
	
	@Override
	public List<T03_Menu> getUserMenu(int uid) {
		Map<String, Object> map = new HashMap<>();
		map.put("uid", uid);
		map.put("pid", 0);
		return menuMapper.selectByUid(map);
	}

}
