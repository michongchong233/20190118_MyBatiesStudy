package com.mickey.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mickey.pojo.User;

/**
 * 用來測試context.xml文件配置數據庫連接池
 */
@WebServlet(
		urlPatterns = { "/11_test" }, 
		initParams = { 
				@WebInitParam(name = "11_test", value = "11_test")
		})
public class T11_ConnectionPoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設置編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Context cxt;
		try {
			//使用JNDI獲取數據庫連接池對象
			cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup("java:comp/env/test");
			Connection conn = ds.getConnection();//連接數據庫成功之後，後面和JDBC的寫法一樣
			PreparedStatement ps = conn.prepareStatement("select * from T41_UserImformation;");
			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while(rs.next()) {
				User u = new User();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setGender(rs.getByte(4));
				u.setAge(rs.getInt(5));
				users.add(u);
			}
			PrintWriter out = response.getWriter();
			out.println("success"+"<br>");
			users.stream().forEach(u->out.println(u.toString()+"<br>"));
			out.flush();
			out.close();
		} catch (NamingException | SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}
