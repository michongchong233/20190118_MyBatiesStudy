package com.mickey.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mickey.pojo.T10_Menu;
import com.mickey.service.T10_MenuService;

@Controller
public class T10_MenuController {
	//springmvc容器調用spring容器的內容
	@Resource
	private T10_MenuService menuServiceImpl;
	
	@RequestMapping("showMenu")
	@ResponseBody
	public List<T10_Menu> showMenu() {
		return menuServiceImpl.shwoMenu();
	}

}
