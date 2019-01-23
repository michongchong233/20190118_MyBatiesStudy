package com.mickey.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.pojo.T20_PageInfo;
import com.mickey.service.T20_UserLimitPageService;

public class T20_UserLimitPageServiceImpl implements T20_UserLimitPageService {
	
	public T20_PageInfo showUser(Integer pageStart, Integer pageSize) throws IOException {
		T20_PageInfo pageInfo = new T20_PageInfo();
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageStart(pageStart);
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageStart", pageSize*(pageStart-1));
		map.put("pageSize", pageSize);
		pageInfo.setList(session.selectList("com.mickey.mapper.User.userLimitPage", map));
		
		int count = session.selectOne("com.mickey.mapper.User.selectCount_20");//Á`±ø¼Æ 
		pageInfo.setPageTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pageInfo;
	}

}
