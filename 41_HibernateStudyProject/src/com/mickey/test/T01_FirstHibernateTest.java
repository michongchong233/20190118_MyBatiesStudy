package com.mickey.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mickey.pojo.T01_User;

public class T01_FirstHibernateTest {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		
		T01_User user = new T01_User();
		user.setUsername("Anna");
		user.setPassword("4321");
		System.out.print(user.toString());
		/*
		將bean實但化對象保存至session裡面，程序員主要是針對session進行操作 
		而hibernate則會查看session是否有對象，對的話將對象放入DB
		 */
		session.save(user);
		
		session.close();
	}

}
