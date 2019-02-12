package com.mickey.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class T12_RequestController {
	@RequestMapping("12_01_test")
	public String demo_01(HttpServletRequest request, HttpSession sessionParam) {
		//request�@�ΰ�
		request.setAttribute("request", "request�@�ΰ쪺��");
		//session�@�ΰ�
		HttpSession session = request.getSession();
		session.setAttribute("session", "session�@�ΰ쪺��");
		//sessionParam�@�ΰ�
		sessionParam.setAttribute("sessionParam", "sessionParam�@�ΰ쪺��");
		//servletContext�@�ΰ�
		ServletContext application = request.getServletContext();
		application.setAttribute("application", "servletContext����");
		return "T12_requestController";
	}
	
	@RequestMapping("12_02_test")
	public String demo_02(Map<String, Object> map) {
		map.put("map", "map����");
		System.out.println(map.getClass());//���Lmap�u����Ҥƪ���
		return "T12_requestController";
	}
	
	@RequestMapping("12_03_test")
	public String demo_03(Model model) {
		model.addAttribute("model", "model����");
		return "T12_requestController";
	}
	
	@RequestMapping("12_04_test")
	public ModelAndView demo_04() {
		//�ѼơA�������
		ModelAndView mav = new ModelAndView("T12_requestController");
		mav.addObject("mav", "ModelAndView����");
		return mav;
	}
}
