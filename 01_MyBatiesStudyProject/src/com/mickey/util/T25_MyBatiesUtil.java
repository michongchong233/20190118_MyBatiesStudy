package com.mickey.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class T25_MyBatiesUtil {
	// SqlSessionFactory��Ҥƪ��L�{�O�@�Ӥ���ӶO�ʯ઺�L�{
	// �O�Ҧ��B�u���@��SqlSessionFactory�A�]�������W�c�إߤu�t
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
	 * ���SqlSession����k util���F�i�H��K�եΡA�򥻤W���|�ϥ�static
	 */
	public static SqlSession getSqlSession() {
		// �p�G�u�{��SqlSession��H�A�ЫءA�_�h����]����
		SqlSession session = tl.get();
		if (session == null) {
			tl.set(factory.openSession());
		}
		return tl.get();
	}

	/**
	 * ����SqlSession
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
