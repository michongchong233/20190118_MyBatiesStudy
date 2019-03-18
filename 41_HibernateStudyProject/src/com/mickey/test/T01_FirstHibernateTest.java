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
	 * class 1，使用最原始的方式操作hibernate
	 * 
	 * @param username
	 * @param password
	 */
	private static void insertUserTest(String username, String password) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();// 開啟事務管理

		T01_User user = new T01_User(0, username, password, null, 0);
		System.out.print(user.toString());
		/*
		 * 將bean實但化對象保存至session裡面，程序員主要是針對session進行操作
		 * 而hibernate則會查看session是否有對象，對的話將對象放入DB
		 */
		session.save(user);
//		tra.commit();//提交事務

		tra.rollback();
		session.close();
	}

	/**
	 * class 2，使用單例模式執行insert操作
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
			tra = session.beginTransaction();// 開啟事務管理
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
	 * class 3，學習hibernate狀態
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
			tra = session.beginTransaction();// 開啟事務管理
			T01_User user = new T01_User(0, "testUsername", "testPassword", null, 0);// 對象為游離態
//			Logger.getLogger(T01_FirstHibernateTest.class).debug(user.toString());
			session.save(user);// 對象與session關連，為持久態，在持久態所做出的變更hibernate同步至數據庫
			user.setUsername(username);
			user.setPassword(password);
			// 對象與session取消關連，為游離態，游離態對象所做的變更hibernate都不會同步至數據庫，還會delete此對象數據
//			session.delete(user);
			user.setUsername("游離態用戶名");
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
	 * class 3，用用戶編園查詢用戶
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
			tra = session.beginTransaction();// 開啟事務管理
			switch (method) {
			case "load":
				// 使用load方法會使用懶加找
				// 懶加載：當調用load方法時，會先回傳一個pojo的代理對象，不會先生成sql至數據庫查詢，等到要用到的時候(getter)才會到數據庫查
				// 優點：節省資源
				user = session.load(T01_User.class, 11);// 用主鍵來查詢
				break;
			case "get":
				// 使用get方法不會使用懶加載，但是會先側緩存找是否有相符的資料，若沒有才會到數據庫查調
				// session緩存-->一級緩存；sessionFactory-->二級緩存
				user = session.get(T01_User.class, 11);
				break;
			}
			System.out.println(user.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			tra.rollback();
		} finally {
//			Logger logger = Logger.getLogger(T01_FirstHibernateTest.class);
//			logger.debug("debug message");//一般在方法內容使用
			tra.commit();
//			tra.rollback();
			session.close();
		}
		return user;
	}

	/**
	 * class 4，聯合主鍵測試個案
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
	 * 組合關系映射，此方法用得不多，比蠅多會用join來做 缺點：很多冗餘數據
	 * 大對象映射：
	 * https://blog.csdn.net/yiguang_820/article/details/79088524
	 * Clob，文本大對象，最長4g
	 * 	private Clob article;
	 * Blob，二進制數據大對象，最長4g
	 * 	private Blob picture;
	 */
	private static void objectRelationalMapping_4() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		try {
			T04_Address address = new T04_Address();
			T04_Person person = new T04_Person();
			address.setCity("台北市");
			address.setStreet("中山路");
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
