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
	 * �d�ߩҦ��Τ�C��
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
	 * �إߥΤ�
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
	 * �Τ�n�J
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
		if (user != null) {//�n�J���\�A�N�Τ�H���s��cookie����ܦ��v�������C��
			System.out.println(user.toString());
			Cookie cookie = new Cookie("uid", Integer.toString(user.getId()));
			response.addCookie(cookie);
			page = "redirect:/menuList.jsp";
		}
		return page;
	}

	/**
	 * �d�ߵ��C��
	 * 
	 * @return
	 */
	@RequestMapping("menuList")
	@ResponseBody
	public List<Menu> selectAllMenu() {
		return userServiceImpl.selectAllMenu();
	}

	/**
	 * �d�ߦ��Τᦳ�v�������C��
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
		if (uid == 0) {// ��cookie���S���s�Τ�s���ɡA���w�V�ܵn�J�e��
			System.out.println("not found id");
			response.sendRedirect("redirect:/30_rbacOriginProject/login.jsp");
		}
		System.out.println(uid);
//		List<Menu> userMenu = userServiceImpl.selectUserMenuByRbac(uid);//�@�몺�v���]�m
		List<Menu> userMenu = userServiceImpl.selectUserMenuByRbac(uid);//rbac���v���]�m
		System.out.println(userMenu.toString());
		return userMenu;
	}

}
