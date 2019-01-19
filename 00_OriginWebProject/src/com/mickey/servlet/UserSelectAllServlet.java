package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.service.impl.UserServiceImpl;

@WebServlet(
		urlPatterns = { "/UserSelectAll" }, 
		initParams = { 
				@WebInitParam(name = "UserSelectAll", value = "UserSelectAll")
		})
public class UserSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設定編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//獲取請求信息
		//處理請求信息
		var userList = new UserServiceImpl().selectAll();
		//響應處理結果
		userList.stream().forEach(u->System.out.println(u.toString()));
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
