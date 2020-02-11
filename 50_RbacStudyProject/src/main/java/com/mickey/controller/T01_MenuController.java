package com.mickey.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mickey.pojo.T01_Menu;
import com.mickey.pojo.T01_User;

@Controller
public class T01_MenuController {

	@RequestMapping("getMenuList")
	@ResponseBody
	public List<T01_Menu> getMenuList(HttpSession session) {
		T01_User user = (T01_User) session.getAttribute("user");
		List<T01_Menu> menus = user.getMenu();
		menus.forEach(m -> System.out.println(m.toString()));
		return menus;
	}

}
