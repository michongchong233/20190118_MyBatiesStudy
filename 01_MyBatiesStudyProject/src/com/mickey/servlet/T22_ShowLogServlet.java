package com.mickey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.pojo.TransferLog;
import com.mickey.service.T21_TransferService;
import com.mickey.service.impl.T21_TransferServiceImpl;

/**
 * 顯示所有轉帳記錄的Servlet
 */
@WebServlet(
		urlPatterns = { "/22_test" }, 
		initParams = { 
				@WebInitParam(name = "22_test", value = "22_test")
		})
public class T22_ShowLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	T21_TransferService ts = new T21_TransferServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 設置編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<TransferLog> logs = ts.selectAllLog();
		request.setAttribute("transferLog", logs);
		request.getRequestDispatcher("T21_TrensferSuccess.jsp").forward(request, response);;
		
	}

}
