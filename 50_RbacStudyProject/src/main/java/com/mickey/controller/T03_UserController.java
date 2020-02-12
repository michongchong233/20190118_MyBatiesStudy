package com.mickey.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mickey.pojo.T03_User;
import com.mickey.service.T03_UserService;

@Controller
public class T03_UserController {

	@Resource
	T03_UserService userService;
	
	@RequestMapping("login_03")
	public String login(T03_User user, HttpSession session) {
		T03_User searchUser = userService.login(user);
		if (searchUser != null) {
			System.out.println(searchUser.toString());
			session.setAttribute("user", searchUser);
			return "redirect:/t03_menu.jsp";
		} else {
			return "redirect:/t03_login.jsp";
		}
	}
}
