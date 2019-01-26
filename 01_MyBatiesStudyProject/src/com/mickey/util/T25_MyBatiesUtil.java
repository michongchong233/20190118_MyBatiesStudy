package com.mickey.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class T25_MyBatiesUtil {
	// SqlSessionFactory實例化的過程是一個比較耗費性能的過程
	// 保證有且只有一個SqlSessionFactory，因為不能頻繁建立工廠
	static private SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();

	static {
		try {
			InputStream is = Resources.getResourceAsStream("myBaties.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 獲取SqlSession的方法 util為了可以方便調用，基本上都會使用static
	 */
	public static SqlSession getSqlSession() {
		// 如果線程有SqlSession對象再創建，否則什麼也不做
		SqlSession session = tl.get();
		if (session == null) {
			tl.set(factory.openSession());
		}
		return tl.get();
	}

	/**
	 * 關閉SqlSession
	 */
	public static void closeSession() {
		SqlSession session = tl.get();
		if (session != null) {
			session.commit();
			session.close();
		}
		tl.set(null);
	}

}
