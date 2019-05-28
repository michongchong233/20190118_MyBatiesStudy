package com.mickey.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mickey.pojo.T01_User;
import com.mickey.pojo.T02_SessionFactorySingleton;
import com.mickey.pojo.T04_Address;
import com.mickey.pojo.T04_Person;
import com.mickey.pojo.T04_Student;
import com.mickey.pojo.T04_StudentId;
import com.mickey.pojo.T05_Address;
import com.mickey.pojo.T05_Company;
import com.mickey.pojo.T05_Course;
import com.mickey.pojo.T05_Department;
import com.mickey.pojo.T05_Employee;
import com.mickey.pojo.T05_Student;
import com.mickey.pojo.T06_User;

public class T01_FirstHibernateTest {
	public static void main(String[] args) {
//		insertUserTest("Anna" ,"4321");
//		insertUserTestUseSingleton("Singleton" ,"34566");
//		insertUserTestUseSingleton_3("changUanme", "223344");
//		selectUserTestUse_3("mike", "1234");
//		hibernateIncrement_4();
//		objectRelationalMapping_4();
//		manyToOneInsert_5();
//		manyToOneInsert_5_1();
//		selectDepartmentByEid_5(1);
//		tryInverse_5();
//		oneToOne_5();
//		manyToMany_5();
		hibernateAnnotation_6();
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
				// 使用load方法會使用懶加載找
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
	 * 組合關系映射，此方法用得不多，比蠅多會用join來做 缺點：很多冗餘數據 大對象映射：
	 * https://blog.csdn.net/yiguang_820/article/details/79088524 Clob，文本大對象，最長4g
	 * private Clob article; Blob，二進制數據大對象，最長4g private Blob picture;
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

	/*
	 * 關系映射
	 * 新增用戶(由多方維護外鍵的值)
	 *  一對一/多對一：hibernate一般使用Set，並加上泛型，如：Set<Employee>
	 *  一般都會做雙向關聯，方便資料查找，便於寫邏輯代碼
	 *  因為當獲取這個部門所有員工時，hibernate會先給一個代理 對象，等要要用的時候才會去查詢(懶加載)，所以使用雙向關聯不用擔心效率問題
	 */
	private static void manyToOneInsert_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		//由多方維護
		T05_Employee employee1 = new T05_Employee();
		T05_Employee employee2 = new T05_Employee();
		T05_Department department = new T05_Department();
		department.setDname("progremer");
		department.setLocation("NewYork");
		employee1.setEname("Lyn");
		employee1.setDepartment(department);
		employee2.setEname("Li");
		employee2.setDepartment(department);
		System.out.println(employee1.toString());
		System.out.println(employee2.toString());
		try {
			session.save(employee1);
			session.save(employee2);
			tra.commit();
		} catch (Exception e){
			e.getStackTrace();
			tra.rollback();
		}finally {
			session.close();
		}
	}
	
	/*
	 * 關系映射
	 * 新增用戶(由單方維護外鍵的值)
	 */
	private static void manyToOneInsert_5_1() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		T05_Department department = new T05_Department();
		T05_Employee employee1 = new T05_Employee();
		T05_Employee employee2 = new T05_Employee();
		employee1.setEname("Ruby");
		employee1.setDepartment(department);
		employee2.setEname("Yang");
		employee2.setDepartment(department);
		department.setDname("marketing");
		department.setLocation("Taipei");
		department.addEmployee(employee1);
		department.addEmployee(employee2);
		try {
			session.save(department);//由一方淮護關聯關系
			tra.commit();
		}catch(Exception e) {
			tra.rollback();
		}finally {
			session.close();
		}
	}
	
	/*
	 * 由一方來維護外鍵的值
	 *inverse="false"
	 * 通過eid獲取department對象，並以聯級的操作刪除此部門及此部門中的員工
	 * 如果有設定好聯級，hibernate會先將子屬性刪除後才會將父屬性刪除
	 */
	private static void selectDepartmentByEid_5(int did) {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		try {
			T05_Department department = session.get(T05_Department.class, did);
			System.out.println("department: " + department.getEmployees());
			session.delete(department);
			tra.commit();
		}catch(Exception e) {
			tra.rollback();
		}finally {
			session.close();
		}
	}
	
	/*
	 * 一對一(外鍵關聯方式)
	 * 如果需要使用主鍵關聯的方式需要將T05_Company.hbm.xml的<meny-to-one>改為<one-to-one>
	 */
	private static void oneToOne_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		try {
			T05_Address address = new T05_Address();
			T05_Company company = new T05_Company();
			address.setCountry("Japen");
			address.setCity("Tokiyo");
			address.setStreet("dontKnow");
			company.setCname("Sony");
			company.setAddress(address);
			session.save(company);
			tra.commit();
		}catch(Exception e) {
			tra.rollback();
		}finally {
			session.close();
		}
	}
	
	/*
	 * 多對多多如：學生與課程，一個學生可以選多門課，一門課可以有多名學生
	 * 過去的做法是建立一張關系對應表，把多對多拆分為彼此一對多
	 */
	private static void manyToMany_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		T05_Course course_01 = new T05_Course();
		course_01.setCname("語文");
		T05_Course course_02 = new T05_Course();
		course_02.setCname("英語");
		T05_Course course_03 = new T05_Course();
		course_03.setCname("數學");
		
		T05_Student student_01 = new T05_Student();
		student_01.setSname("Mickey");
		T05_Student student_02 = new T05_Student();
		student_02.setSname("Mike");
		T05_Student student_03 = new T05_Student();
		student_03.setSname("Android");
		
		//選課
		student_01.addCource(course_01);
		student_01.addCource(course_02);
		student_01.addCource(course_03);
		
		student_02.addCource(course_01);
		student_02.addCource(course_02);
		
		student_03.addCource(course_01);
		
		session.save(student_01);
		session.save(student_02);
		session.save(student_03);
		tra.commit();
		
	}
	
	/*
	 * hibernate注解的使用
	 */
	private static void hibernateAnnotation_6() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		try {
			T06_User user_01 = new T06_User();
			user_01.setUname("Yang");
			user_01.setUage(18);
			user_01.setUbirth(LocalDate.now());
			session.save(user_01);
			tra.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
//		System.out.println(session.get(T06_User.class, 1).toString());
	}

}
