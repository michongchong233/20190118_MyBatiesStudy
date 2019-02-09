package com.mickey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/" }, //代表不過濾jsp，也就是.jsp文件都不走此servlet
		initParams = { 
				@WebInitParam(name = "01_test", value = "01_test")
		})
/*
 * front設計模式，前端設計模式，SpringMVC就是根據此設計模式的框架
 */
public class T01_OriginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("執行控制器");
		String str = request.getParameter("control");
		System.out.println(str);
		if(str != null) {
			switch(str) {
			case "demo1":
				demo1();
				break;
			case "demo2":
				demo2();
				break;
			case "demo3":
				demo3();
				break;
			case "demo4":
				demo4();
				break;
			default:
				System.out.println("什麼也不做");
			}
		}
	}

	private void demo1() {
		System.out.println("demo1被調用");
	}

	private void demo2() {
		System.out.println("demo2被調用");
	}

	private void demo3() {
		System.out.println("demo3被調用");
	}

	private void demo4() {
		System.out.println("demo4被調用");
	}
}
