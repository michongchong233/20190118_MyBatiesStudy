package com.mickey.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class T02_FirstSpringMvcController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("°õ¦æspring mvc±±¨î¾¹");
		ModelAndView mav = new ModelAndView("T01_index.jsp");
		return mav;
	}

}
