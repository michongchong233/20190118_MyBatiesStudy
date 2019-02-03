package com.mickey.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mickey.pojo.T23_Person;

public class T23_AutoImportTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		T23_Person person = ac.getBean("t23_Person", T23_Person.class);
		System.out.println(person.toString());
	}

}
