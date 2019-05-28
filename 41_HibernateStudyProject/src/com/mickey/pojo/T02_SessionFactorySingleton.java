package com.mickey.pojo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/*
 * 使用餓漢式包裝hibernate的sessionFactory
 */
public class T02_SessionFactorySingleton {
	private static SessionFactory sessionFactory;
	private static SessionFactory annotationSessionFactory;

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

	public static SessionFactory getAnnotationSessionFactory() {
		if(annotationSessionFactory == null) {
			synchronized(T02_SessionFactorySingleton.class) {
				if(annotationSessionFactory == null) {
					StandardServiceRegistry standardRegistry = 
							new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
					Metadata metaData = 
							new MetadataSources(standardRegistry).getMetadataBuilder().build();
					annotationSessionFactory = metaData.getSessionFactoryBuilder().build();
				}
			}
		}
		return annotationSessionFactory;
	}
	
}
