package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.pojo.T20_PageInfo;
import com.mickey.service.T20_UserLimitPageService;
import com.mickey.service.impl.T20_UserLimitPageServiceImpl;

/**
 * ¤À­¶¬d¸ßªºServlet
 */
@WebServlet(
		urlPatterns = { "/20_test" }, 
		initParams = { 
				@WebInitParam(name = "20_test", value = "20_test")
		})
public class T20_UserLimitPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private T20_UserLimitPageService userService = new T20_UserLimitPageServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageStart = Integer.parseInt(request.getParameter("pageStart"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		T20_PageInfo pageInfo = userService.showUser(pageStart, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher("T20_showPage.jsp").forward(request, response);
	}

}
