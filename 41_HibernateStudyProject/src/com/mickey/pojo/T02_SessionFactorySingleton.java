package com.mickey.pojo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * 使用餓漢式包裝hibernate的sessionFactory
 */
public class T02_SessionFactorySingleton {
	private static SessionFactory sessionFactory;

	private T02_SessionFactorySingleton() {
		super();
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			synchronized(T02_SessionFactorySingleton.class) {
				if(sessionFactory == null) {
					Configuration conf = new Configuration();
					conf.configure();
					sessionFactory = conf.buildSessionFactory();
				}
			}
		}
		return sessionFactory;
	}
	
}
