package com.mickey.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T11_AopTest {

	public static void main(String[] args) throws Exception {
//		T11_AopDemo aop = new T11_AopDemo();
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		T11_AopDemo aop = ac.getBean("T11_AopDemo", T11_AopDemo.class);
		aop.demo_01();
		aop.demo_02(5, "Mickey");
		aop.demo_04("Mickey");
		aop.demo_05();

	}

}
