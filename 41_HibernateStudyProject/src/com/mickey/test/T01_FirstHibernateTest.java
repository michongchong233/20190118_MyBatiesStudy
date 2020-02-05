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
//		tryHql_7();// �d�ߦh��H�����ABean�ʸ˳浧���
//		tryHql_7_1();// �d�߳��H
//		tryHql_7_2();// �d�ߦh��H�������AObject[]�ʸ˳浧���
//		tryHql_7_3();// �d�ߦh��H�������AMap�ʸ˳浧���
//		tryHql_7_4();// �d�߳��H�������ABean�ʸ˳浧���
//		tryHql_7_5();// where�d�߱���ϥ�
//		tryHql_7_6();// where�d�߱���ϥ�
//		tryHql_7_7();// hql�����d��
//		tryHql_7_8();// join�A���s���A�~�s��
//		tryHql_7_9();// SQL��ͬd��
		tryHql_7_10();// SQL��ͬd��
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
		tra.commit();// ����ư�

//		tra.rollback();
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
			tra.commit();
//			tra.rollback();
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
				// �ϥ�load��k�|�ϥ��i�[����
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
	 * �զX���t�M�g�A����k�αo���h�A���Ǧh�|��join�Ӱ� ���I�G�ܦh���l�ƾ� �j��H�M�g�G
	 * https://blog.csdn.net/yiguang_820/article/details/79088524 Clob�A�奻�j��H�A�̪�4g
	 * private Clob article; Blob�A�G�i��ƾڤj��H�A�̪�4g private Blob picture;
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

	/*
	 * ���t�M�g �s�W�Τ�(�Ѧh����@�~�䪺��) �@��@/�h��@�Ghibernate�@��ϥ�Set�A�å[�W�x���A�p�GSet<Employee>
	 * �@�볣�|�����V���p�A��K��Ƭd��A�K��g�޿�N�X �]��������o�ӳ����Ҧ����u�ɡAhibernate�|�����@�ӥN�z
	 * ��H�A���n�n�Ϊ��ɭԤ~�|�h�d��(�i�[��)�A�ҥH�ϥ����V���p���ξ�߮Ĳv���D
	 */
	private static void manyToOneInsert_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		// �Ѧh����@
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
	 * ���t�M�g �s�W�Τ�(�ѳ����@�~�䪺��)
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
			session.save(department);// �Ѥ@��a�@���p���t
			tra.commit();
		} catch (Exception e) {
			tra.rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * �Ѥ@��Ӻ��@�~�䪺�� inverse="false" �q�Leid���department��H�A�åH�p�Ū��ާ@�R���������Φ������������u
	 * �p�G���]�w�n�p�šAhibernate�|���N�l�ݩʧR����~�|�N���ݩʧR��
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
	 * �@��@(�~�����p�覡) �p�G�ݭn�ϥΥD�����p���覡�ݭn�NT05_Company.hbm.xml��<meny-to-one>�אּ<one-to-one>
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
	 * �h��h�h�p�G�ǥͻP�ҵ{�A�@�Ӿǥͥi�H��h���ҡA�@���ҥi�H���h�W�ǥ� �L�h�����k�O�إߤ@�i���t������A��h��h����������@��h
	 */
	private static void manyToMany_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		T05_Course course_01 = new T05_Course();
		course_01.setCname("�y��");
		T05_Course course_02 = new T05_Course();
		course_02.setCname("�^�y");
		T05_Course course_03 = new T05_Course();
		course_03.setCname("�ƾ�");

		T05_Student student_01 = new T05_Student();
		student_01.setSname("Mickey");
		T05_Student student_02 = new T05_Student();
		student_02.setSname("Mike");
		T05_Student student_03 = new T05_Student();
		student_03.setSname("Android");

		// ���
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
	 * hibernate�`�Ѫ��ϥ�
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
	 * �`���ϥΡA�@��@
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
	 * �`���ϥΡA�@��h
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
	 * �`���ϥΡA�h��h
	 */
	private static void annotationManyToMany_6() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		Transaction tra = session.beginTransaction();
		T06_Course course_01 = new T06_Course();
		course_01.setCname("���z");
		T06_Course course_02 = new T06_Course();
		course_02.setCname("�ƾ�");
		T06_Course course_03 = new T06_Course();
		course_03.setCname("�ͪ�");

		T06_Student student_01 = new T06_Student();
		student_01.setSname("Ruby");
		T06_Student student_02 = new T06_Student();
		student_02.setSname("Weiss");
		T06_Student student_03 = new T06_Student();
		student_03.setSname("Black");

		// ���
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
	 * hql�h��H�d�ߡA�ϥ�Bean�i��ʸ�
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
	 * hql���H�d�ߡA�p���ƼơA��Number�Τ@�B�z�����K�F�����T�O�d�ߥX�����G�@�w�n���@�ӡA���M�|�����`
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
	 * hql�h��H�d�߳������A�i�H�ھڹ�H���ݩʪ����d�߭ȡA�Ӥ���join �ϥ�Object[]�i��ʸ�
	 */
	private static void tryHql_7_2() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select e.eid, e.ename, e.department.dname from T06_Employee e";// ����S�w���
		Query query = session.createQuery(hql);
		List<T06_Employee[]> results = query.list();
		for (int i = 0; i < results.size(); i++) {
			Object[] os = results.get(i);
			System.out.println(os[0] + " " + os[1] + " " + os[2]);
		}
		session.close();
	}

	/**
	 * hql�h��H�d�߳������A�ϥ�Map�i��ʸˡA�@��Map���@���O��
	 */
	private static void tryHql_7_3() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select new map("//
				+ "e.eid as eid, e.ename as ename, e.department.dname as departmentName"// ���d��
				+ ")from T06_Employee e";// �@���ĳ�_�O�W�B�z�d�X���r�q
		Query query = session.createQuery(hql);
		List<Map> mapList = query.list();
		mapList.forEach(map -> {
			// �ϥΧO�W����
			System.out.println(map.get("eid") + " " + map.get("ename") + " " + map.get("departmentName"));
		});
		session.close();
	}

	/**
	 * hql�h��H�d�߳������A�ϥ�Bean�i��ʸˡA�ݭn�q�L�c�y��k
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
	 * hql where�d�߱���ϥΡA��k�@
	 */
	private static void tryHql_7_5() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select new T06_Employee("//
				+ "e.eid, e.ename"//
				+ ") from T06_Employee e "//
				+ "where ename = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, "mickey");// �ھڱ��󶶧ǳ]�w�ȡA���ޱq0�p��
		List<T06_Employee> empList = query.list();
		empList.forEach(emp -> {
			System.out.println(emp.getEid() + " " + emp.getEname());
		});
		session.close();
	}

	/**
	 * hql where�d�߱���ϥΡA��k�G(��ĳ�ϥ�)�A�i�ʺA�j�w
	 */
	private static void tryHql_7_6() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "select new T06_Employee("//
				+ "e.eid, e.ename"//
				+ ") from T06_Employee e "//
				+ "where ename = :ename";
		Query query = session.createQuery(hql);
		query.setParameter("ename", "mickey");// �ھڱ���W�ٳ]�w��
		List<T06_Employee> empList = query.list();
		empList.forEach(emp -> {
			System.out.println(emp.getEid() + " " + emp.getEname());
		});
		session.close();
	}

	/**
	 * �ϥ�hql��{�����d��
	 */
	private static void tryHql_7_7() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		String hql = "from T06_Employee";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);// �q�ĴX���}�lŪ�����
		query.setMaxResults(2);// �]�m�C�@���̦h��ܰO�����Ӽ�

		List<T06_Employee> empList = query.list();
		empList.forEach(emp -> {
			System.out.println(emp.getEid() + " " + emp.getEname());
		});
		session.close();
	}

	/**
	 * join�A���s���A�~�s��
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
	 * SQL��ͬd��(Native SQL)�A�Mjdbc�ϥήt�O���j
	 */
	private static void tryHql_7_9() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		//�ϥέ��sql�A�@�w�n�ϥΪ�W�d��
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
	 * SQL��ͬd��(Native SQL)�A�ϥ�select * �ñN�d�ߵ��G��ܹ�������
	 */
	private static void tryHql_7_10() {
		SessionFactory factory = T02_SessionFactorySingleton.getAnnotationSessionFactory();
		Session session = factory.openSession();
		//�ϥέ��sql�A�@�w�n�ϥΪ�W�d��
		String sql = "select * from hibernate_t05_employee where ename=:ename";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("ename", "mickey");
		query.addEntity(T06_Employee.class);//�s�W��������H
		List<T06_Employee> empList = query.list();
		for (int i = 0; i < empList.size(); i++) {
			T06_Employee emp = empList.get(i);
			System.out.println(emp.getEid() + " " + emp.getEname());
		}
		session.close();
	}

}
