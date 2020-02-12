package com.mickey.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mickey.pojo.T03_Menu;
import com.mickey.service.T03_MenuService;

@Controller
public class T03_MenuController {

	@Resource
	T03_MenuService menuService;
	
	@RequestMapping("getMenuList_03")
	@ResponseBody
	public List<T03_Menu> getMenuList(HttpSession session){
		int uid = (int) session.getAttribute("uid");
		List<T03_Menu> menuList = menuService.getUserMenu(uid);
		menuList.forEach(m -> System.out.println(m.toString()));
		return menuList;
	}
	
}
