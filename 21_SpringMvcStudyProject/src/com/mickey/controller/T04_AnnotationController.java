package com.mickey.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mickey.pojo.T05_People;

@Controller // 將此類交由springmvc管理
public class T04_AnnotationController {
	@RequestMapping("03_01_test")
	public String demo_01() {
		System.out.println("執行demo_01");
		return "/T01_index.jsp";
	}

	// 傳入基本類型參數
	@RequestMapping("05_01_test")
	public String demo_02(String name, int age) {
		System.out.println(name + " " + age);
		System.out.println("執行demo_02");
		return "/T01_index.jsp";
	}

	// 使用對象名的屬性名自動獲取類型值
	@RequestMapping("05_02_test")
	public String Demo_03(T05_People peo, HttpServletRequest request) {
		System.out.println(peo.toString());
		System.out.println("執行demo_03");
		request.setAttribute("str", "測試使用spirngmvc傳值");
		return "/T01_index.jsp";
	}

	// 傳入基本類型參數, 如果請求參數名和方法參數名不對應使用
	@RequestMapping("05_03_test")
	public String demo_04(//
			@RequestParam(value = "name") String name_new, //
			@RequestParam(value = "age") int age_new) {
		System.out.println(name_new + " " + age_new);
		System.out.println("執行demo_04");
		return "/T01_index.jsp";
	}

	// 設置默認值方法參數是基本數據類型，防止無參數時500
	// 必填值
	@RequestMapping("05_04_test")
	public String demo_05(//
			@RequestParam(defaultValue = "2") Integer pageStart, //
			@RequestParam(required = true) String name,
			@RequestParam(required = true,defaultValue = "55") int age) {
		System.out.println(pageStart + " " + name + "(必填)" + age);
		System.out.println("執行demo_05");
		return "/T01_index.jsp";
	}

}
