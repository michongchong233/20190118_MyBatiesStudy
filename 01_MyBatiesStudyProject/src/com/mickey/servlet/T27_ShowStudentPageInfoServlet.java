package com.mickey.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mickey.pojo.T27_PageInfo;
import com.mickey.service.T27_StudentService;
import com.mickey.service.impl.T27_StudentServiceImpl;

/**
 * �ϥΤ��P����d�߾ǥͩM�Ѯv�H����Servlet
 */
@WebServlet(urlPatterns = { "/27_test" }, initParams = { @WebInitParam(name = "27_test", value = "27_test") })
public class T27_ShowStudentPageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	T27_StudentService ss = new T27_StudentServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �]�m�ШD�M�T�����s�X�榡
		request.setCharacterEncoding("UTF-8");
		response.setContentType("test/html;charset=UTF-8");
		// ����ШD�H��
		String sname = request.getParameter("sname");
		if (sname != null && sname != "") {
			sname = new String(sname.getBytes("iso-8859-1"), "utf-8");// �}�o����ĳ�ϥγo�ؤ覡�A����ĳ��tomcat�t�m
		}

		String tname = request.getParameter("tname");
		if (tname != null && tname != "") {
			tname = new String(tname.getBytes("iso-8859-1"), "utf-8");
		}

		String pageSizeStr = request.getParameter("pageSizeStr");
		String pageNumberStr = request.getParameter("pageNumberStr");
		// �B�z�ШD�H��
		T27_PageInfo pi = ss.showPage(sname, tname, pageSizeStr, pageNumberStr);
		// �T���B�z���G
		System.out.println(pi.toString());
		request.setAttribute("pageInfo", pi);
		request.getRequestDispatcher("T27_ShowPage.jsp").forward(request, response);

	}

}
