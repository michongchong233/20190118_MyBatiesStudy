package com.mickey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class T17_InterceptorTest {
	@RequestMapping("17_01_test")
	public ModelAndView demo_01() {
		System.out.println("do demo_01()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("T01_index");
		modelAndView.addObject("model", "model value");
//		int i = 1/0;
		return modelAndView;
	}
}
