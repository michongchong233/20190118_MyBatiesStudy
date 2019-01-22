package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
//		selectCount();
//		selectMap();
//		System.out.println(selectById(1)!=null?selectById(1).toString():null);

		// User user = new User();
//		user.setUid(1);//設定要傳入的參數
//		System.out.println(selectById_2(user)!=null?selectById_2(user).toString():null);

//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("uid", 1);// 設定要傳入的多個參數
//		map.put("uname", "test1");
//		System.out.println(selectById_3(map) != null ? selectById_3(map).toString() : null);
		
//		Map<String, Integer> map_1 = new HashMap<String, Integer>();
//		map_1.put("pageStart", 2);//第幾頁
//		map_1.put("pageSize", 2);//第幾個
//		if(selectLimit(map_1)!=null)selectLimit(map_1).stream().forEach(u->System.out.println(u.toString()));

//		User user_insert = new User();
//		user_insert.setUname("myBateisTestUser");
//		user_insert.setPassword("s13579");
//		user_insert.setGender((byte) 1);
//		user_insert.setAge(55);
//		System.out.println(insertUser(user_insert));
		
//		System.out.println(deleteUser(19));
		
//		Map<String, Object> map_2 = new HashMap<String, Object>();
//		map_2.put("uid", 20);
//		map_2.put("password", "SSSS");
//		System.out.println(updateUserPasswordById(map_2));
		
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

	/**
	 * session.selectOne("com.mickey.mapper.User.selectById", id);
	 * 設定參數查找User，配置文件使用占位符以及#{}獲取對象
	 */
	private static User selectById(int id) {
		InputStream is;
		User user = null;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			user = session.selectOne("com.mickey.mapper.User.selectById", id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * session.selectOne("com.mickey.mapper.User.selectById_2", u);
	 * 設定參數查找User，配置文件使用字符串拼接以及${}獲取對象
	 */
	private static User selectById_2(User u) {
		InputStream is;
		User user = null;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			user = session.selectOne("com.mickey.mapper.User.selectById_2", u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * session.selectOne("com.mickey.mapper.User.selectById", id); 使用map設定多個參數查找User
	 */
	private static User selectById_3(Map<String, Object> map) {
		InputStream is;
		User user = null;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			user = session.selectOne("com.mickey.mapper.User.selectById_3", map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 分頁顯示
	 */
	private static List<User> selectLimit(Map<String, Integer> map) {
		InputStream is;
		List<User> userList = null;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			userList = session.selectList("com.mickey.mapper.User.limitPage", map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	/**
	 * 新增用戶
	 */
	private static int insertUser(User user) {
		InputStream is;
		int updateNum = 0;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			updateNum = session.insert("com.mickey.mapper.User.insertUser", user);
			session.commit();//若新增期間沒有錯誤，確認提交事務
		} catch (IOException e) {
			e.printStackTrace();
		}
		return updateNum;
	}
	
	/**
	 * 刪除用戶
	 */
	private static int deleteUser(int id) {
		InputStream is;
		int updateNum = 0;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			updateNum = session.delete("com.mickey.mapper.User.deleteUser", id);
			session.commit();//若新增期間沒有錯誤，確認提交事務
		} catch (IOException e) {
			e.printStackTrace();
		}
		return updateNum;
	}
	
	/**
	 * 修改用戶密碼
	 */
	private static int updateUserPasswordById(Map map) {
		InputStream is;
		int updateNum = 0;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			updateNum = session.update("com.mickey.mapper.User.updateUserPasswordById", map);
			session.commit();//若新增期間沒有錯誤，確認提交事務
		} catch (IOException e) {
			e.printStackTrace();
		}
		return updateNum;
	}

}
