package com.mickey.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

import com.mickey.pojo.T01_User;
import com.mickey.pojo.T02_SessionFactorySingleton;

public class T01_FirstHibernateTest {
	public static void main(String[] args) {
//		insertUserTest("Anna" ,"4321");
		insertUserTestUseSingleton("Singleton" ,"34566");
	}
	
	/**
	 * class 1，使用最原始的方式操作hibernate
	 * @param username
	 * @param password
	 */
	private static void insertUserTest(String username, String password) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();//開啟事務管理
		
		T01_User user = new T01_User(0, username, password, null, 0);
		System.out.print(user.toString());
		/*
		將bean實但化對象保存至session裡面，程序員主要是針對session進行操作 
		而hibernate則會查看session是否有對象，對的話將對象放入DB
		 */
		session.save(user);
//		tra.commit();//提交事務

		tra.rollback();
		session.close();
	}
	
	/**
	 * 使用單例模式執行insert操作
	 * @param username
	 * @param password
	 */
	private static void insertUserTestUseSingleton(String username, String password) {
		Session session = null;
		Transaction tra = null;
		try{
			SessionFactory factory =T02_SessionFactorySingleton.getSessionFactory();
			session = factory.openSession();
			tra = session.beginTransaction();//開啟事務管理
			T01_User user = new T01_User(0, username, password, null, 0);
			Logger.getLogger(T01_FirstHibernateTest.class).debug(user.toString());
			session.save(user);
		}catch(Exception ex){
			ex.printStackTrace();
			tra.rollback();
		}finally {
//			tra.commit();
			tra.rollback();
			session.close();
		}
	}

}
