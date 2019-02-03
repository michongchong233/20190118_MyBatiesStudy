package com.mickey.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mickey.pojo.T23_Person;
import com.mickey.pojo.T24_User;

public class T23_AutoImportTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		T23_Person person = ac.getBean("t23_Person", T23_Person.class);
		System.out.println(person.toString());
		
		//����class 24�A�`�J.properties��󤺮e
		T24_User user = ac.getBean("t24_User", T24_User.class);
		System.out.println(user.toString());
	}

}
