package com.mickey.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mickey.pojo.T08_Student;
import com.mickey.service.T08_StudentService;

public class T04_IocTest {

	public static void main(String[] args) {
		//對象實例的原來方式
//		T04_Person person_01 = new T04_Person();
//		System.out.println(person_01.toString());
		
		//委托Spring實例對象，默認在加載ApplicationConext.xml時調用無參構造方法
//		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");//加載Spring配置文件
//		T04_Person person_02 = ac.getBean("T04_Person_02", T04_Person.class);
//		System.out.println(person_02.toString());
//		
//		//運用實例工廠創建對象的原來方式
//		T05_PersonFactory factory = new T05_PersonFactory();
//		T04_Person a1 = factory.createPerson("A");
//		
//		//委托Spring運用工廠模式實例對象
//		T05_PersonExtendsA a2 = (T05_PersonExtendsA) ac.getBean("T05_Factory_a");
//		System.out.println(a2.toString());
//		
//		//運用靜態工廠創建對象的原來方式
//		T04_Person a3 = T05_PersonFactoryStatic.createPerson("A");
//		
//		//委托Spring運用靜態實例對象
//		T05_PersonExtendsA a4 = (T05_PersonExtendsA) ac.getBean("T05_Factory_Static");
//		
//		//設值注入(通過setter)
//		T04_Person person_03 = ac.getBean("T06_Person_03", T04_Person.class);
//		System.out.println(person_03.toString());
		
		//使用Spring框架整合MyBatis
		//ClassPathXmlApplicationContext默認去classes文件夾根目錄開始尋找
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		String[] names = ac.getBeanDefinitionNames();//獲取所有Spring管理的Bean名稱
		for(String name:names) System.out.println(name);
		T08_StudentService studentService = ac.getBean("T08_StudentService", T08_StudentService.class);
		List<T08_Student> students = studentService.selectAllStudent();
		students.stream().forEach(s->System.out.println(s.toString()));
		
		
		
	}

}
