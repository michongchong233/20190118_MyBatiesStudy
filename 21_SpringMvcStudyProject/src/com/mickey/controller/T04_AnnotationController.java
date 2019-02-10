package com.mickey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//將此類交由springmvc管理
public class T04_AnnotationController {
	@RequestMapping("03_01_test")
	public String demo_01() {
		System.out.println("執行demo_01");
		return "/T01_index.jsp";
	}
}
