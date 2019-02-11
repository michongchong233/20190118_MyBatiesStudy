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
			@RequestParam(required = true) String name, @RequestParam(required = true, defaultValue = "55") int age) {
		System.out.println(pageStart + " " + name + "(必填)" + age);
		System.out.println("執行demo_05");
		return "/T01_index.jsp";
	}

	// 請求參數中包含多個同名參數的獲取方式
	// 如：複選框傳遞的參數就是多個同名參數
	@RequestMapping("06_01_test")
	public String demo_06(String name, int age, @RequestParam("hover") ArrayList<String> hover) {
		System.out.println("name:" + name + " age:" + age);
		System.out.print("hover:");
		hover.stream().forEach(h -> System.out.println(h));
		System.out.println("執行demo_06");
		return "/T01_index.jsp";
	}

	// 請求參數中對象
	@RequestMapping("06_02_test")
	public String demo_07(T06_Demo demo) {
		System.out.println(demo.toString());
		System.out.println("執行demo_07");
		return "/T01_index.jsp";
	}

	@RequestMapping("06_03_test")
	public String demo_08(T06_DemoList demo) {
		System.out.println(demo.toString());
		System.out.println("執行demo_08");
		return "/T01_index.jsp";
	}

	@RequestMapping("06_04_test/{name}/{age}")//請求格式
	//@PathVariable中一定要和請求式對應，否則需要另訂名稱
	//使用@PathVariable獲取@RequestMapping中內容，默認按照方法參數名稱去尋找
	public String demo_09(@PathVariable String name, @PathVariable("age") int age_new) {
		System.out.println("執行demo_09 " + name + " " + age_new);
		return "/T01_index.jsp";
	}
	
	@RequestMapping("07_test")
	public String demo_10() {
		System.out.println("執行demo_10，重定向");
		return "redirect:/T01_index.jsp";
	}

}
