package com.mickey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mickey.mapper.T05_UrlMapper;
import com.mickey.pojo.T05_Url;
import com.mickey.service.T05_UrlService;

@Service
public class T05_UrlServiceImpl implements T05_UrlService {
	
	@Resource
	T05_UrlMapper urlMapper;

	@Override
	public List<T05_Url> getUrlList(int uid) {
		return urlMapper.selectByUid(uid);
	}

	@Override
	public List<T05_Url> getAllUrl() {
		return urlMapper.selectAll();
	}

}
