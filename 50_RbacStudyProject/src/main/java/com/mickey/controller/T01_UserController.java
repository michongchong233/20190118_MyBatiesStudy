package com.mickey.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mickey.pojo.T01_User;
import com.mickey.service.T01_UserService;

@Controller //Spring的注解，將此容器交紷SpringMVC管理
public class T01_UserController {
	@Resource
	private T01_UserService userService;
	
	@RequestMapping("login")
	public String logIn(T01_User user, HttpSession session) {
		T01_User searchUser = userService.logIn(user);
		if(searchUser != null) {
			session.setAttribute("user", searchUser);
			return "redirect:/t01_menu.jsp";
		} else {
			return "redirect:/t01_login.jsp";
		}
	}
}
