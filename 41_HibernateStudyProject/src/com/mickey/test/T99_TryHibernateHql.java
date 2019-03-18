package com.mickey.test;

import java.util.List;

import org.hibernate.Session;

import com.mickey.pojo.T01_User;
import com.mickey.pojo.T02_SessionFactorySingleton;

public class T99_TryHibernateHql {

	public static void main(String[] args) {
		selectAllUserHql();
	}
	
	private static void selectAllUserHql() {
		Session session = T02_SessionFactorySingleton.getSessionFactory().openSession();
		String hql = "from T01_User";//from�᭱�������O�ƾڮw����W�A�O�������W�A�n�`�N
		List<T01_User> users = session.createQuery(hql).list();
		users.stream().forEach(u->{System.out.println(u.toString());});
		session.close();
	}

}
