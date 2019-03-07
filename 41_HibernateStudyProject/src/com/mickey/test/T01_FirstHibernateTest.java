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
	 * class 1�A�ϥγ̭�l���覡�ާ@hibernate
	 * @param username
	 * @param password
	 */
	private static void insertUserTest(String username, String password) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();//�}�ҨưȺ޲z
		
		T01_User user = new T01_User(0, username, password, null, 0);
		System.out.print(user.toString());
		/*
		�Nbean����ƹ�H�O�s��session�̭��A�{�ǭ��D�n�O�w��session�i��ާ@ 
		��hibernate�h�|�d��session�O�_����H�A�諸�ܱN��H��JDB
		 */
		session.save(user);
//		tra.commit();//����ư�

		tra.rollback();
		session.close();
	}
	
	/**
	 * �ϥγ�ҼҦ�����insert�ާ@
	 * @param username
	 * @param password
	 */
	private static void insertUserTestUseSingleton(String username, String password) {
		Session session = null;
		Transaction tra = null;
		try{
			SessionFactory factory =T02_SessionFactorySingleton.getSessionFactory();
			session = factory.openSession();
			tra = session.beginTransaction();//�}�ҨưȺ޲z
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
