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
//		insertUserTestUseSingleton("Singleton" ,"34566");
//		insertUserTestUseSingleton_3("changUanme", "223344");
		selectUserTestUse_3("mike", "1234");
	}

	/**
	 * class 1�A�ϥγ̭�l���覡�ާ@hibernate
	 * 
	 * @param username
	 * @param password
	 */
	private static void insertUserTest(String username, String password) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();// �}�ҨưȺ޲z

		T01_User user = new T01_User(0, username, password, null, 0);
		System.out.print(user.toString());
		/*
		 * �Nbean����ƹ�H�O�s��session�̭��A�{�ǭ��D�n�O�w��session�i��ާ@
		 * ��hibernate�h�|�d��session�O�_����H�A�諸�ܱN��H��JDB
		 */
		session.save(user);
//		tra.commit();//����ư�

		tra.rollback();
		session.close();
	}

	/**
	 * class 2�A�ϥγ�ҼҦ�����insert�ާ@
	 * 
	 * @param username
	 * @param password
	 */
	private static void insertUserTestUseSingleton(String username, String password) {
		Session session = null;
		Transaction tra = null;
		try {
			SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
			session = factory.openSession();
			tra = session.beginTransaction();// �}�ҨưȺ޲z
			T01_User user = new T01_User(0, username, password, null, 0);
			Logger.getLogger(T01_FirstHibernateTest.class).debug(user.toString());
			session.save(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			tra.rollback();
		} finally {
//			tra.commit();
			tra.rollback();
			session.close();
		}
	}

	/**
	 * class 3�A�ǲ�hibernate���A
	 * 
	 * @param username
	 * @param password
	 */
	private static void insertUserTestUseSingleton_3(String username, String password) {
		Session session = null;
		Transaction tra = null;
		try {
			SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
			session = factory.openSession();
			tra = session.beginTransaction();// �}�ҨưȺ޲z
			T01_User user = new T01_User(0, "testUsername", "testPassword", null, 0);// ��H�������A
			Logger.getLogger(T01_FirstHibernateTest.class).debug(user.toString());
			session.save(user);// ��H�Psession���s�A�����[�A�A�b���[�A�Ұ��X���ܧ�hibernate�P�B�ܼƾڮw
			user.setUsername(username);
			user.setPassword(password);
			// ��H�Psession�������s�A�������A�A�����A��H�Ұ����ܧ�hibernate�����|�P�B�ܼƾڮw�A�ٷ|delete����H�ƾ�
//			session.delete(user);
			user.setUsername("�����A�Τ�W");
			session.update(user);// org.hibernate.ObjectDeletedException: deleted instance passed to update()
		} catch (Exception ex) {
			ex.printStackTrace();
			tra.rollback();
		} finally {
			tra.commit();
//			tra.rollback();
			session.close();
		}
	}

	/**
	 * �ΥΤ�s��d�ߥΤ�
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private static int selectUserTestUse_3(String username, String password) {
		Session session = null;
		Transaction tra = null;
		String method = "get";
		T01_User user = null;
		try {
			SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
			session = factory.openSession();
			tra = session.beginTransaction();// �}�ҨưȺ޲z
			switch (method) {
			case "load":
				// �ϥ�load��k�|�ϥ��i�[��
				// �i�[���G���ե�load��k�ɡA�|���^�Ǥ@��pojo���N�z��H�A���|���ͦ�sql�ܼƾڮw�d�ߡA����n�Ψ쪺�ɭ�(getter)�~�|��ƾڮw�d
				// �u�I�G�`�ٸ귽
				user = session.load(T01_User.class, 11);// �ΥD��Ӭd��
				break;
			case "get":
				// �ϥ�get��k���|�ϥ��i�[���A���O�|�����w�s��O�_���۲Ū���ơA�Y�S���~�|��ƾڮw�d��
				// session�w�s-->�@�Žw�s�FsessionFactory-->�G�Žw�s
				user = session.get(T01_User.class, 11);
				break;
			}
			System.out.println(user.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			tra.rollback();
		} finally {
			tra.commit();
//			tra.rollback();
			session.close();
		}
		return 0;
	}

}