package com.mickey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//�N�������springmvc�޲z
public class T04_AnnotationController {
	@RequestMapping("03_01_test")
	public String demo_01() {
		System.out.println("����demo_01");
		return "/T01_index.jsp";
	}
}
