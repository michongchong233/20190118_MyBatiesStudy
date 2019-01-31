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
 * 驗證登入信息的Servlet
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
		String uname = request.getParameter("uname");//用戶名
		String password = request.getParameter("password");//密碼
		HttpSession session = request.getSession();//取得Session
		String codeStr = (String) session.getAttribute("code");//系統生成的驗證碼
		String userCode = request.getParameter("userCode");//用戶輸入的驗證碼
		if(codeStr.equals(userCode)) {
			User user = userService.loginSelect(uname, password);
			response.sendRedirect(user!=null?"success.jsp":"fail.jsp");//此用戶名和密碼找不到對應的用戶重定向至fail.jsp
		}else {//驗證碼輸入失敗
			response.sendRedirect("fail.jsp");
		}
	}

}
