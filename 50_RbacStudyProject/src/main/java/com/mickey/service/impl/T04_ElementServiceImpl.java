package com.mickey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.T04_ElementMapper;
import com.mickey.pojo.T04_Element;
import com.mickey.service.T04_ElementService;

@Service
public class T04_ElementServiceImpl implements T04_ElementService{

	@Resource
	T04_ElementMapper elementMapper; 
	
	@Override
	public List<T04_Element> getElementList(int uid) {
		return elementMapper.selectByUid(uid);
	}

}
