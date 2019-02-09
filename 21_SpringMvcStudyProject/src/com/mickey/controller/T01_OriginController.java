package com.mickey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/" }, //�N���L�ojsp�A�]�N�O.jsp��󳣤�����servlet
		initParams = { 
				@WebInitParam(name = "01_test", value = "01_test")
		})
/*
 * front�]�p�Ҧ��A�e�ݳ]�p�Ҧ��ASpringMVC�N�O�ھڦ��]�p�Ҧ����ج[
 */
public class T01_OriginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���汱�");
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
				System.out.println("����]����");
			}
		}
	}

	private void demo1() {
		System.out.println("demo1�Q�ե�");
	}

	private void demo2() {
		System.out.println("demo2�Q�ե�");
	}

	private void demo3() {
		System.out.println("demo3�Q�ե�");
	}

	private void demo4() {
		System.out.println("demo4�Q�ե�");
	}
}
