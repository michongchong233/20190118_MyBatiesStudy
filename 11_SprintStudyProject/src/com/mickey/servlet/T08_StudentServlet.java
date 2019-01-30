package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mickey.service.T08_StudentService;
import com.mickey.service.impl.T08_StudentServiceImpl;

@WebServlet("/08_test")
public class T08_StudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	T08_StudentService studentService;
	
	@Override
	public void init() throws ServletException{
		//��Service��ҤơA���O�S�O�n���g�k�A���Ӧbtomcat�ҰʮɴN�[��ApplicationContext.xml�A�ݭn��web.xml�t�m
//		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//Spring�Mweb��X��Ҧ��H�����s��bwebApplicationContext
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		studentService = ac.getBean("T08_StudentService", T08_StudentServiceImpl.class);
		
	}	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", studentService.selectAllStudent());
		request.getRequestDispatcher("T08_index.jsp").forward(request, response);
		
	}
	
}
