package com.mickey.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component("T18_AopDemo")
public class T18_AopDemo {

	public T18_AopDemo() {
		super();
		System.out.println("�ե�T11_AopDemo�L�Ѻc�y��");
	}

	/**
	 * ���յL�Ѫ���k���I
	 */
	@Pointcut("execution(* com.mickey.test.T18_AopDemo.*(..))")//�w�q���I
	public void demo_01() {
		System.out.println("����demo_01()�D�餺�e");
	}

	/**
	 * ���զ��Ѫ���k���I
	 */
	public void demo_02(int id, String name) {
		System.out.println("����demo_01()�D�餺�e: " + id + " " + name);
	}

	/**
	 * ���յL�]�m���I����k
	 */
	public void demo_03() {
		System.out.println("����demo_03()�D�餺�e");
	}

	/**
	 * ���զ���^�Ȫ����I
	 */
	public String demo_04(String name) {
		System.out.println("����demo_04()�D�餺�e");
		return name;
	}

	/**
	 * ���ղ��`�q��
	 */
	@Pointcut("execution(* com.mickey.test.T18_AopDemo.*(..))")
	public void demo_05() throws Exception {
		int i = 5 / 0;
		System.out.println("����demo_05()�D�餺�e");
	}
	
	/**
	 * ������¶�q��
	 */
	public void demo_06() {
		System.out.println("����demo_06()�D�餺�e");
	}
	

}
