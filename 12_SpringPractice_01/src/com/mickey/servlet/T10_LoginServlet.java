package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mickey.pojo.User;
import com.mickey.service.UserService;
import com.mickey.service.impl.UserServiceImpl;

/**
 * ���ҵn�J�H����Servlet
 */
@WebServlet(urlPatterns = { "/10_test" }, initParams = { @WebInitParam(name = "10_test", value = "10_test") })
public class T10_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService;

	@Override
	public void init() throws ServletException{
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService = ac.getBean("userService", UserServiceImpl.class);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");//�Τ�W
		String password = request.getParameter("password");//�K�X
		HttpSession session = request.getSession();//���oSession
		String codeStr = (String) session.getAttribute("code");//�t�Υͦ������ҽX
		String userCode = request.getParameter("userCode");//�Τ��J�����ҽX
		if(codeStr.equals(userCode)) {
			User user = userService.loginSelect(uname, password);
			response.sendRedirect(user!=null?"success.jsp":"fail.jsp");//���Τ�W�M�K�X�䤣��������Τ᭫�w�V��fail.jsp
		}else {//���ҽX��J����
			response.sendRedirect("fail.jsp");
		}
	}

}
