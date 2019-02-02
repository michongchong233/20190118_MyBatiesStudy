package com.mickey.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ����pring AOP
 */
public class T11_AopTest {

	public static void main(String[] args) {
//		T11_AopDemo aop = new T11_AopDemo();
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		testXmlAop(ac);//���ըϥ�xml�t�mSpring AOP
		testComponentAop(ac);

	}
	
	/*
	 * ���ըϥ�xml�t�mSpring AOP
	 */
	private static void testXmlAop(ClassPathXmlApplicationContext ac) {
		T11_AopDemo aop = ac.getBean("T11_AopDemo", T11_AopDemo.class);
//		aop.demo_01();
		aop.demo_02(5, "Mickey");
//		aop.demo_04("Mickey");
//		try {
//			aop.demo_05();
//		} catch (Exception e) {
////			e.printStackTrace();
//		}
//		aop.demo_06();
	}
	
	/*
	 * ���ըϥΪ`���t�mSpring AOP
	 */
	private static void testComponentAop(ClassPathXmlApplicationContext ac) {
		T18_AopDemo aop = ac.getBean("T18_AopDemo", T18_AopDemo.class);
		aop.demo_01();
		try {
			aop.demo_05();
		} catch (Exception e) {
//		e.printStackTrace();
		}
	}

}
