package com.mickey.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mickey.pojo.Menu;
import com.mickey.pojo.User;
import com.mickey.service.UserService;

@Controller
public class UserController {
	@Resource
	UserService userServiceImpl;

	/**
	 * 查詢所有用戶列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("userList")
	public String selectAllUser(HttpServletRequest request) {
		List<User> user = userServiceImpl.selectAllUser();
		System.out.println(user.toString());
		request.setAttribute("users", user);
		return "userList";
	}

	/**
	 * 建立用戶
	 * 
	 * @return
	 */
	@RequestMapping("createUser")
	public String createUser(HttpServletRequest request) {
		String page = "error";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		int insertNum = userServiceImpl.createUser(username, password);
		if (insertNum == 1)
			page = "redirect:/userList";
		return page;
	}

	/**
	 * 用戶登入
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String doLogin(HttpServletRequest request, HttpServletResponse response) {
		String page = "redirect:/error.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		User user = userServiceImpl.doLogin(username, password);
		if (user != null) {//登入成功，將用戶信息存至cookie並轉至有權限的菜單列表
			System.out.println(user.toString());
			Cookie cookie = new Cookie("uid", Integer.toString(user.getId()));
			response.addCookie(cookie);
			page = "redirect:/menuList.jsp";
		}
		return page;
	}

	/**
	 * 查詢菜單列表
	 * 
	 * @return
	 */
	@RequestMapping("menuList")
	@ResponseBody
	public List<Menu> selectAllMenu() {
		return userServiceImpl.selectAllMenu();
	}

	/**
	 * 查詢此用戶有權限的菜單列表
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("menuUserList")
	@ResponseBody
	public List<Menu> selectUserMenu(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid = 0;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("uid")) {
				uid = Integer.parseInt(cookie.getValue());
				break;
			}
			System.out.println(cookie.getName() + ":" + cookie.getValue());
		}
		if (uid == 0) {// 當cookie中沒有存用戶編號時，重定向至登入畫面
			System.out.println("not found id");
			response.sendRedirect("redirect:/30_rbacOriginProject/login.jsp");
		}
		System.out.println(uid);
//		List<Menu> userMenu = userServiceImpl.selectUserMenuByRbac(uid);//一般的權限設置
		List<Menu> userMenu = userServiceImpl.selectUserMenuByRbac(uid);//rbac的權限設置
		System.out.println(userMenu.toString());
		return userMenu;
	}

}
