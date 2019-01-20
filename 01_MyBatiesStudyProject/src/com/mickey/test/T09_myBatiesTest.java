package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.pojo.User;

public class T09_myBatiesTest {

	public static void main(String[] args) {
		selectAll();
		selectCount();
		selectMap();
	}

	/**
	 * session.selectList("selectAll");
	 */
	private static void selectAll() {
		InputStream is;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");// 指到myBaties配置文件
			// SqlSessionFactory，使用工廠設計模式
			// SqlSessionFactoryBuilder()，構建者設計模式，當某些比較複雜的類進行實例化時，可以通過構建者快速地實例化對象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			// 生産SqlSession
			SqlSession session = factory.openSession();
			List<User> list = session.selectList("selectAll");
			list.stream().forEach(l -> System.out.println(l.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * session.selectOne("selectOne"); 適用於返回結果只是變量或一行數據時
	 */
	private static void selectCount() {
		InputStream is;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			int count = session.selectOne("com.mickey.mapper.User.selectCount");// 返回resultType設置的類型或對象
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * session.selectMap("com.mickey.mapper.User.selectMap", "uname"); Map<key,
	 * resultType控制類型> 適用於需求需要在查詢結果中通過某列的值取到這行數據的需求
	 */
	private static void selectMap() {
		InputStream is;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			// 把數據庫中哪個列的值當作map的key
			Map<Object, Object> map = session.selectMap("com.mickey.mapper.User.selectMap", "uname");
			Set<Object> userName = map.keySet();
			for (Object u : userName) {
				System.out.println(map.get(u));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
