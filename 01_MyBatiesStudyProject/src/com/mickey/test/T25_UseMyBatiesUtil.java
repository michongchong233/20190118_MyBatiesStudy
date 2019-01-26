package com.mickey.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mickey.mapper.T23_UserMapper;
import com.mickey.pojo.User;
import com.mickey.util.T25_MyBatiesUtil;

/**
 * 學習使用ThreadLocal建立myBatiesUtil並使用
 */
public class T25_UseMyBatiesUtil {
	public static void main(String[] args) {
		SqlSession session = T25_MyBatiesUtil.getSqlSession();//如果從Servlet進來的話則不用寫這一句，因為filter已經做了
		T23_UserMapper um = session.getMapper(T23_UserMapper.class);
		List<User> users = um.selectAll();
		users.stream().forEach(u->System.out.println(u.toString()));
	}
}
