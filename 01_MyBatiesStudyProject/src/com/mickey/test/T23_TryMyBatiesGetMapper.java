package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.mapper.T23_UserMapper;
import com.mickey.pojo.User;

/**
 * 測試使用getMapper接口綁定、多參數傳遞
 */
public class T23_TryMyBatiesGetMapper {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		//T23_UserMapper接口被實例化：需要給接口一個實例化對象(多型)，使用JDK本身的貸理設計模式
		T23_UserMapper um = session.getMapper(T23_UserMapper.class);
		
		//查詢全部用戶信息
		List<User> users = um.selectAll();
		users.stream().forEach(u->System.out.println(u.toString()));
		
//		//根據uid和uname查詢用戶
//		User user = um.selectById(4, "mickey");
//		System.out.println(user!=null?user.toString():"查無此用戶");
	}
}
