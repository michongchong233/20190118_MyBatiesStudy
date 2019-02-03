package com.mickey.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mickey.pojo.T23_Person;
import com.mickey.pojo.T24_User;
import com.mickey.pojo.T25_ScopeSingleton;

public class T23_AutoImportTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		T23_Person person = ac.getBean("t23_Person", T23_Person.class);
		System.out.println(person.toString());
		
		//����class 24�A�`�J.properties��󤺮e
		T24_User user = ac.getBean("t24_User", T24_User.class);
		System.out.println(user.toString());
		
		//����class 25�A<bean scope="">
		T25_ScopeSingleton test1 = ac.getBean("t25_ScopeSingleton", T25_ScopeSingleton.class);
		T25_ScopeSingleton test2 = ac.getBean("t25_ScopeSingleton", T25_ScopeSingleton.class);
		System.out.println(test1 == test2);//<bean>��ñ��������H�q�{�O��Ҫ�
		System.out.println("test1: " + test1);
		System.out.println("test2: " + test2);
		
		//����class 26�A��ҼҦ�_�i�~��
		T26_SingleTon singl_01 = T26_SingleTon.getInstance();
		T26_SingleTon singl_02 = T26_SingleTon.getInstance();
		System.out.println("singl_01: " + singl_01);
		System.out.println("singl_02: " + singl_02);
		
		
	}

}
