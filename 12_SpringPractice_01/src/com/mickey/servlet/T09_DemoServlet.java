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
 * 圖片響應的Servlet
 */
@WebServlet(
		urlPatterns = { "/09_01_test" }, 
		initParams = { 
				@WebInitParam(name = "09_01_test", value = "09_01_test")
		})
public class T09_DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//所有數據的請求和響應都是流的體現
		//當tomcat解析到href或src時就會發出一個異步請求給service，service找到資源後就會執行輸出流給瀏覽器
//		PrintWriter out = response.getWriter();//專門放文字信息
//		out.write("輸出字節流");
		
		ServletOutputStream os = response.getOutputStream();//獲取響應流，可放圖片…資源
		InputStream is = new FileInputStream(new File(getServletContext().getRealPath("images"), "img_a.png"));
//		RequestDispatcher path = getServletContext().getRequestDispatcher("images");
//		File file = new File(path, "img_a.png");
//		InputStream is = new FileInputStream(file);
		int index = -1;
		while((index=is.read()) != -1) {//讀取流裡面的東西
			os.write(index);
		}
		
		
		
	
	}

}
