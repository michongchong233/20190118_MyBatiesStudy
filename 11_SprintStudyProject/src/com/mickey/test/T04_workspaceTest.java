package com.mickey.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mickey.pojo.T04_Person;
import com.mickey.pojo.T05_PersonExtendsA;
import com.mickey.pojo.T05_PersonFactory;
import com.mickey.pojo.T05_PersonFactoryStatic;

public class T04_workspaceTest {

	public static void main(String[] args) {
		//��H��Ҫ���Ӥ覡
//		T04_Person person_01 = new T04_Person();
//		System.out.println(person_01.toString());
		
		//�e��Spring��ҹ�H�A�q�{�b�[��ApplicationConext.xml�ɽեεL�Ѻc�y��k
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");//�[��Spring�t�m���
//		T04_Person person_02 = ac.getBean("T04_Person_02", T04_Person.class);
//		System.out.println(person_02.toString());
//		
//		//�B�ι�Ҥu�t�Ыع�H����Ӥ覡
//		T05_PersonFactory factory = new T05_PersonFactory();
//		T04_Person a1 = factory.createPerson("A");
//		
//		//�e��Spring�B�Τu�t�Ҧ���ҹ�H
//		T05_PersonExtendsA a2 = (T05_PersonExtendsA) ac.getBean("T05_Factory_a");
//		System.out.println(a2.toString());
//		
//		//�B���R�A�u�t�Ыع�H����Ӥ覡
//		T04_Person a3 = T05_PersonFactoryStatic.createPerson("A");
//		
//		//�e��Spring�B���R�A��ҹ�H
//		T05_PersonExtendsA a4 = (T05_PersonExtendsA) ac.getBean("T05_Factory_Static");
		
		//�]�Ȫ`�J(�q�Lsetter)
		T04_Person person_03 = ac.getBean("T06_Person_03", T04_Person.class);
		System.out.println(person_03.toString());
		
	}

}
