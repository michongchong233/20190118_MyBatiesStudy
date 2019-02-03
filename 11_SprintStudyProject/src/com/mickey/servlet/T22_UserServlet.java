package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mickey.pojo.T22_User;
import com.mickey.service.T22_UserService;
import com.mickey.service.impl.T22_UserServiceImpl;

@WebServlet("/22_test")
public class T22_UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	T22_UserService us;

	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		us = ac.getBean("T22_UserService", T22_UserServiceImpl.class);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		T22_User user = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		if (uname != null && password != null) {
			user = us.login(uname, password);
			if (user != null) {// 登入成功
				response.sendRedirect("T22_main.jsp");
			} else {// 登入失敗
				response.sendRedirect("T22_login.jsp");
			}
		}else {
			response.sendRedirect("T22_login.jsp");
		}
	}

}
