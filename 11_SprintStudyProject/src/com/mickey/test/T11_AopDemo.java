package com.mickey.test;

public class T11_AopDemo {
	
	public T11_AopDemo() {
		super();
		System.out.println("�ե�T11_AopDemo�L�Ѻc�y��");
	}

	/**
	 * ���յL�Ѫ���k���I
	 */
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

}
