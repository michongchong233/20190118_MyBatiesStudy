package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.pojo.MessageCode;
import com.mickey.service.T21_TransferService;
import com.mickey.service.impl.T21_TransferServiceImpl;

/**
 * 
 */
@WebServlet(urlPatterns = { "/21_account" }, initParams = { @WebInitParam(name = "21_account", value = "21_account") })
public class T21_TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	T21_TransferService ts = new T21_TransferServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 設定編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 取得請求信息
		String OutAccName = request.getParameter("OutAccName");
		String OutPassword = request.getParameter("OutPassword");
		double money = Double.parseDouble(request.getParameter("money"));
		String InAccName = request.getParameter("InAccName");
		String InName = request.getParameter("InName");
		MessageCode mc = ts.transferAccount(OutAccName, OutPassword, money, InAccName, InName);
		System.out.println(mc.getErrorNum() + ":" + mc.getMessage());

	}

}
