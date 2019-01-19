package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatiesTest {

	public static void main(String[] args) {
		InputStream is;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			//SqlSessionFactory，使用工廠設計模式
			//SqlSessionFactoryBuilder()，構建者設計模式，當某些比較複雜的類進行實例化時，可以通過構建者快速地實例化對象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
