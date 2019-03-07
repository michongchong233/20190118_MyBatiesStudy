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
		�Nbean����ƹ�H�O�s��session�̭��A�{�ǭ��D�n�O�w��session�i��ާ@ 
		��hibernate�h�|�d��session�O�_����H�A�諸�ܱN��H��JDB
		 */
		session.save(user);
		
		session.close();
	}

}
