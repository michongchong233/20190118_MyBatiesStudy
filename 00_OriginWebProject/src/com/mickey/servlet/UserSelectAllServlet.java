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
		//�]�w�s�X�榡
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//����ШD�H��
		//�B�z�ШD�H��
		var userList = new UserServiceImpl().selectAll();
		//�T���B�z���G
		userList.stream().forEach(u->System.out.println(u.toString()));
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
