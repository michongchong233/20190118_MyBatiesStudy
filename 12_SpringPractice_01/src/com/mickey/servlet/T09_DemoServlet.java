package com.mickey.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �Ϥ��T����Servlet
 */
@WebServlet(
		urlPatterns = { "/09_01_test" }, 
		initParams = { 
				@WebInitParam(name = "09_01_test", value = "09_01_test")
		})
public class T09_DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ҧ��ƾڪ��ШD�M�T�����O�y����{
		//��tomcat�ѪR��href��src�ɴN�|�o�X�@�Ӳ��B�ШD��service�Aservice���귽��N�|�����X�y���s����
//		PrintWriter out = response.getWriter();//�M�����r�H��
//		out.write("��X�r�`�y");
		
		ServletOutputStream os = response.getOutputStream();//����T���y�A�i��Ϥ��K�귽
		InputStream is = new FileInputStream(new File(getServletContext().getRealPath("images"), "img_a.png"));
//		RequestDispatcher path = getServletContext().getRequestDispatcher("images");
//		File file = new File(path, "img_a.png");
//		InputStream is = new FileInputStream(file);
		int index = -1;
		while((index=is.read()) != -1) {//Ū���y�̭����F��
			os.write(index);
		}
		
		
		
	
	}

}
