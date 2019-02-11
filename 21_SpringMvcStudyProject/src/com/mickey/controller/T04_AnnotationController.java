package com.mickey.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mickey.pojo.T05_People;
import com.mickey.pojo.T06_Demo;
import com.mickey.pojo.T06_DemoList;

@Controller // �N�������springmvc�޲z
public class T04_AnnotationController {
	@RequestMapping("03_01_test")
	public String demo_01() {
		System.out.println("����demo_01");
		return "/T01_index.jsp";
	}

	// �ǤJ�������Ѽ�
	@RequestMapping("05_01_test")
	public String demo_02(String name, int age) {
		System.out.println(name + " " + age);
		System.out.println("����demo_02");
		return "/T01_index.jsp";
	}

	// �ϥι�H�W���ݩʦW�۰����������
	@RequestMapping("05_02_test")
	public String Demo_03(T05_People peo, HttpServletRequest request) {
		System.out.println(peo.toString());
		System.out.println("����demo_03");
		request.setAttribute("str", "���ըϥ�spirngmvc�ǭ�");
		return "/T01_index.jsp";
	}

	// �ǤJ�������Ѽ�, �p�G�ШD�ѼƦW�M��k�ѼƦW�������ϥ�
	@RequestMapping("05_03_test")
	public String demo_04(//
			@RequestParam(value = "name") String name_new, //
			@RequestParam(value = "age") int age_new) {
		System.out.println(name_new + " " + age_new);
		System.out.println("����demo_04");
		return "/T01_index.jsp";
	}

	// �]�m�q�{�Ȥ�k�ѼƬO�򥻼ƾ������A����L�ѼƮ�500
	// �����
	@RequestMapping("05_04_test")
	public String demo_05(//
			@RequestParam(defaultValue = "2") Integer pageStart, //
			@RequestParam(required = true) String name, @RequestParam(required = true, defaultValue = "55") int age) {
		System.out.println(pageStart + " " + name + "(����)" + age);
		System.out.println("����demo_05");
		return "/T01_index.jsp";
	}

	// �ШD�ѼƤ��]�t�h�ӦP�W�Ѽƪ�����覡
	// �p�G�ƿ�ضǻ����ѼƴN�O�h�ӦP�W�Ѽ�
	@RequestMapping("06_01_test")
	public String demo_06(String name, int age, @RequestParam("hover") ArrayList<String> hover) {
		System.out.println("name:" + name + " age:" + age);
		System.out.print("hover:");
		hover.stream().forEach(h -> System.out.println(h));
		System.out.println("����demo_06");
		return "/T01_index.jsp";
	}

	// �ШD�ѼƤ���H
	@RequestMapping("06_02_test")
	public String demo_07(T06_Demo demo) {
		System.out.println(demo.toString());
		System.out.println("����demo_07");
		return "/T01_index.jsp";
	}

	@RequestMapping("06_03_test")
	public String demo_08(T06_DemoList demo) {
		System.out.println(demo.toString());
		System.out.println("����demo_08");
		return "/T01_index.jsp";
	}

	@RequestMapping("06_04_test/{name}/{age}")//�ШD�榡
	//@PathVariable���@�w�n�M�ШD�������A�_�h�ݭn�t�q�W��
	//�ϥ�@PathVariable���@RequestMapping�����e�A�q�{���Ӥ�k�ѼƦW�٥h�M��
	public String demo_09(@PathVariable String name, @PathVariable("age") int age_new) {
		System.out.println("����demo_09 " + name + " " + age_new);
		return "/T01_index.jsp";
	}
	
	@RequestMapping("07_test")
	public String demo_10() {
		System.out.println("����demo_10�A���w�V");
		return "redirect:/T01_index.jsp";
	}

}
