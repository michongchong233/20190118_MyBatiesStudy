package com.mickey.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
import com.mickey.pojo.T06_Address;
import com.mickey.pojo.T06_Company;
import com.mickey.pojo.T06_Course;
import com.mickey.pojo.T06_Department;
import com.mickey.pojo.T06_Employee;
import com.mickey.pojo.T06_Student;
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
//		hibernateAnnotation_6();
//		annotationOneToOne_6();
//		annotationOneToMany_6();
//		annotationManyToMany_6();
//		tryHql_7();// 查詢多對象全欄位，Bean封裝單筆資料
//		tryHql_7_1();// 查詢單對象
//		tryHql_7_2();// 查詢多對象部分欄位，Object[]封裝單筆資料
//		tryHql_7_3();// 查詢多對象部分欄位，Map封裝單筆資料
//		tryHql_7_4();// 查詢單對象部分欄位，Bean封裝單筆資料
//		tryHql_7_5();// where查詢條件使用
//		tryHql_7_6();// where查詢條件使用
//		tryHql_7_7();// hql分頁查詢
//		tryHql_7_8();// join，內連接，外連接
//		tryHql_7_9();// SQL原生查詢
		tryHql_7_10();// SQL原生查詢
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
		tra.commit();// 提交事務

//		tra.rollback();
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
			tra.commit();
//			tra.rollback();
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
	 * 關系映射 新增用戶(由多方維護外鍵的值) 一對一/多對一：hibernate一般使用Set，並加上泛型，如：Set<Employee>
	 * 一般都會做雙向關聯，方便資料查找，便於寫邏輯代碼 因為當獲取這個部門所有員工時，hibernate會先給一個代理
	 * 對象，等要要用的時候才會去查詢(懶加載)，所以使用雙向關聯不用擔心效率問題
	 */
	private static void manyToOneInsert_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		// 由多方維護
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
		} catch (Exception e) {
			e.getStackTrace();
			tra.rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * 關系映射 新增用戶(由單方維護外鍵的值)
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
			session.save(department);// 由一方淮護關聯關系
			tra.commit();
		} catch (Exception e) {
			tra.rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * 由一方來維護外鍵的值 inverse="false" 通過eid獲取department對象，並以聯級的操作刪除此部門及此部門中的員工
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
		} catch (Exception e) {
			tra.rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * 一對一(外鍵關聯方式) 如果需要使用主鍵關聯的方式需要將T05_Company.hbm.xml的<meny-to-one>改為<one-to-one>
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
		} catch (Exception e) {
			tra.rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * 多對多多如：學生與課程，一個學生可以選多門課，一門課可以有多名學生 過去的做法是建立一張關系對應表，把多對多拆分為彼此一對多
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

		// 選課
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
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
//		System.out.println(session.get(T06_User.class, 1).toString());
	}

	/**
	 * 注釋使用，一對一
	 */
	private static void annotationOneToOne_6() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		try {
			T06_Address address = new T06_Address();
			T06_Company company = new T06_Company();
			address.setCountry("China");
			address.setCity("Beijing");
			address.setStreet("ZhongZhenRoad");
			company.setCname("Huawei");
			company.setAddress(address);
			session.save(company);
			tra.commit();
		} catch (Exception e) {
			tra.rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 注釋使用，一對多
	 */
	private static void annotationOneToMany_6() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		T06_Department department = new T06_Department();
		T06_Employee employee1 = new T06_Employee();
		T06_Employee employee2 = new T06_Employee();
		employee1.setEname("Weiss");
		employee2.setEname("Black");
		employee1.setDepartment(department);
		employee2.setDepartment(department);
		department.setDname("Progemer");
		department.setLocation("USA");
		department.addEmployee(employee1);
		department.addEmployee(employee2);
		try {
			session.save(department);
			tra.commit();
		} catch (Exception e) {
			tra.rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 注釋使用，多對多
	 */
	private static void annotationManyToMany_6() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		T06_Course course_01 = new T06_Course();
		course_01.setCname("物理");
		T06_Course course_02 = new T06_Course();
		course_02.setCname("化學");
		T06_Course course_03 = new T06_Course();
		course_03.setCname("生物");

		T06_Student student_01 = new T06_Student();
		student_01.setSname("Ruby");
		T06_Student student_02 = new T06_Student();
		student_02.setSname("Weiss");
		T06_Student student_03 = new T06_Student();
		student_03.setSname("Black");

		// 選課
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

	/**
	 * hql多對象查詢，使用Bean進行封裝
	 */
	private static void tryHql_7() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		String hql = "from T06_Employee";
		Query query = session.createQuery(hql);
		List list = query.list();
		list.forEach(l -> {
			System.out.println(l.toString());
		});
		session.close();
	}

	/**
	 * hql單對象查詢，計算資料數，用Number統一處理比較方便；必須確保查詢出的結果一定要有一個，不然會報異常
	 */
	private static void tryHql_7_1() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		String hql = "select count(*) from T06_Employee";
		Query query = session.createQuery(hql);
		Number count = (Number) query.uniqueResult();
		System.out.println("total count : " + count.intValue());
		session.close();
	}

	/**
	 * hql多對象查詢部分欄位，可以根據對象的屬性直接查詢值，而不用join 使用Object[]進行封裝
	 */
	private static void tryHql_7_2() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select e.eid, e.ename, e.department.dname from T06_Employee e";// 選取特定欄位
		Query query = session.createQuery(hql);
		List<T06_Employee[]> results = query.list();
		for (int i = 0; i < results.size(); i++) {
			Object[] os = results.get(i);
			System.out.println(os[0] + " " + os[1] + " " + os[2]);
		}
		session.close();
	}

	/**
	 * hql多對象查詢部分欄位，使用Map進行封裝，一個Map為一條記錄
	 */
	private static void tryHql_7_3() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select new map("//
				+ "e.eid as eid, e.ename as ename, e.department.dname as departmentName"// 跨表查詢
				+ ")from T06_Employee e";// 一般建議起別名處理查出的字段
		Query query = session.createQuery(hql);
		List<Map> mapList = query.list();
		mapList.forEach(map -> {
			// 使用別名取值
			System.out.println(map.get("eid") + " " + map.get("ename") + " " + map.get("departmentName"));
		});
		session.close();
	}

	/**
	 * hql多對象查詢部分欄位，使用Bean進行封裝，需要通過構造方法
	 */
	private static void tryHql_7_4() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select new T06_Employee("//
				+ "e.eid, e.ename"//
				+ ") from T06_Employee e";
		Query query = session.createQuery(hql);
		List<T06_Employee> empList = query.list();
		empList.forEach(emp -> {
			System.out.println(emp.getEid() + " " + emp.getEname());
		});
		session.close();
	}

	/**
	 * hql where查詢條件使用，方法一
	 */
	private static void tryHql_7_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select new T06_Employee("//
				+ "e.eid, e.ename"//
				+ ") from T06_Employee e "//
				+ "where ename = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, "mickey");// 根據條件順序設定值，索引從0計算
		List<T06_Employee> empList = query.list();
		empList.forEach(emp -> {
			System.out.println(emp.getEid() + " " + emp.getEname());
		});
		session.close();
	}

	/**
	 * hql where查詢條件使用，方法二(建議使用)，可動態綁定
	 */
	private static void tryHql_7_6() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select new T06_Employee("//
				+ "e.eid, e.ename"//
				+ ") from T06_Employee e "//
				+ "where ename = :ename";
		Query query = session.createQuery(hql);
		query.setParameter("ename", "mickey");// 根據條件名稱設定值
		List<T06_Employee> empList = query.list();
		empList.forEach(emp -> {
			System.out.println(emp.getEid() + " " + emp.getEname());
		});
		session.close();
	}

	/**
	 * 使用hql實現分頁查詢
	 */
	private static void tryHql_7_7() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "from T06_Employee";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);// 從第幾條開始讀取資料
		query.setMaxResults(2);// 設置每一頁最多顯示記錄的個數

		List<T06_Employee> empList = query.list();
		empList.forEach(emp -> {
			System.out.println(emp.getEid() + " " + emp.getEname());
		});
		session.close();
	}

	/**
	 * join，內連接，外連接
	 */
	private static void tryHql_7_8() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select e.eid, e.ename, dep.dname "//
				+ "from T06_Employee e "//
				+ "left join e.department dep";
		Query query = session.createQuery(hql);
		List<T06_Employee[]> results = query.list();
		for (int i = 0; i < results.size(); i++) {
			Object[] os = results.get(i);
			System.out.println(os[0] + " " + os[1] + " " + os[2]);
		}
		session.close();
	}

	/**
	 * SQL原生查詢(Native SQL)，和jdbc使用差別不大
	 */
	private static void tryHql_7_9() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		//使用原生sql，一定要使用表名查詢
		String sql = "select eid, ename from hibernate_t05_employee where ename=:ename";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("ename", "mickey");
		List empList = query.list();
		for (int i = 0; i < empList.size(); i++) {
			Object[] o = (Object[]) empList.get(i);
			System.out.println(o[0] + " " + o[1]);
		}
		session.close();
	}


	/**
	 * SQL原生查詢(Native SQL)，使用select * 並將查詢結果放至實體類中
	 */
	private static void tryHql_7_10() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		//使用原生sql，一定要使用表名查詢
		String sql = "select * from hibernate_t05_employee where ename=:ename";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("ename", "mickey");
		query.addEntity(T06_Employee.class);//新增實體類對象
		List<T06_Employee> empList = query.list();
		for (int i = 0; i < empList.size(); i++) {
			T06_Employee emp = empList.get(i);
			System.out.println(emp.getEid() + " " + emp.getEname());
		}
		session.close();
	}

}
