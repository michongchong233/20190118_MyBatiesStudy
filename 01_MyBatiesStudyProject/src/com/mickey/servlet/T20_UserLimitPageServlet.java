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
 * 分頁查詢的Servlet
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
		//第一次訪問的驗證，如果沒有傳遞參數，設置默認值
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 6;
		if(pageSizeStr!=null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		String pageStartStr = request.getParameter("pageStart");
		int pageStart = 1;
		if(pageStartStr!=null && !pageStartStr.equals("")) {
			pageStart = Integer.parseInt(pageStartStr);
		}
		
		T20_PageInfo pageInfo = userService.showUser(pageStart, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		request.getRequestDispatcher("T20_showPage.jsp").forward(request, response);
	}

}
