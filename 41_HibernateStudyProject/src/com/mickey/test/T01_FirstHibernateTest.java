package com.mickey.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mickey.pojo.T01_User;
import com.mickey.pojo.T02_SessionFactorySingleton;
import com.mickey.pojo.T04_Address;
import com.mickey.pojo.T04_Person;
import com.mickey.pojo.T04_Student;
import com.mickey.pojo.T04_StudentId;

public class T01_FirstHibernateTest {
	public static void main(String[] args) {
//		insertUserTest("Anna" ,"4321");
//		insertUserTestUseSingleton("Singleton" ,"34566");
//		insertUserTestUseSingleton_3("changUanme", "223344");
//		selectUserTestUse_3("mike", "1234");
//		hibernateIncrement_4();
		objectRelationalMapping_4();
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
//			Logger.getLogger(T01_FirstHibernateTest.class).debug(user.toString());
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
//			Logger.getLogger(T01_FirstHibernateTest.class).debug(user.toString());
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
	 * class 3�A�ΥΤ�s��d�ߥΤ�
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private static T01_User selectUserTestUse_3(String username, String password) {
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
				// �i�[���G��ե�load��k�ɡA�|���^�Ǥ@��pojo���N�z��H�A���|���ͦ�sql�ܼƾڮw�d�ߡA����n�Ψ쪺�ɭ�(getter)�~�|��ƾڮw�d
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
//			Logger logger = Logger.getLogger(T01_FirstHibernateTest.class);
//			logger.debug("debug message");//�@��b��k���e�ϥ�
			tra.commit();
//			tra.rollback();
			session.close();
		}
		return user;
	}

	/**
	 * class 4�A�p�X�D����խӮ�
	 */
	private static void hibernateIncrement_4() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		try {
			T04_Student student = new T04_Student();
			T04_StudentId studentId = new T04_StudentId();
			studentId.setFirstname("mickey");
			studentId.setLastname("mini");
			student.setColumnKey(studentId);
			student.setMajor("java");
			session.save(student);
			tra.commit();
		} catch (Exception e) {
			tra.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * �զX���t�M�g�A����k�αo���h�A���Ǧh�|��join�Ӱ� ���I�G�ܦh���l�ƾ�
	 * �j��H�M�g�G
	 * https://blog.csdn.net/yiguang_820/article/details/79088524
	 * Clob�A�奻�j��H�A�̪�4g
	 * 	private Clob article;
	 * Blob�A�G�i��ƾڤj��H�A�̪�4g
	 * 	private Blob picture;
	 */
	private static void objectRelationalMapping_4() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		try {
			T04_Address address = new T04_Address();
			T04_Person person = new T04_Person();
			address.setCity("�x�_��");
			address.setStreet("���s��");
			address.setZipcode(123456);
			person.setName("mickey");
			person.setAddress(address);
			System.out.println(person.toString());
			session.save(person);
			tra.commit();
		} catch (Exception e) {
			e.getStackTrace();
			tra.rollback();
		} finally {
			session.close();
		}

	}

}
