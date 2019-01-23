package com.mickey.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.service.T20_UserLimitPageService;
import com.mickey.service.impl.T20_UserLimitPageServiceImpl;

/**
 * 建立用戶Servlet
 */
@WebServlet(
		urlPatterns = { "/21_test" }, 
		initParams = { 
				@WebInitParam(name = "21_test", value = "21_test")
		})
public class T21_CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private T20_UserLimitPageService userService = new T20_UserLimitPageServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		byte gender = Byte.parseByte(request.getParameter("gender"));
		int age = Integer.parseInt(request.getParameter("age"));
		int updateNum = userService.createUser(uname, password, gender, age);
		if(updateNum>0) {
			response.sendRedirect("20_test");
		}
	}

}
