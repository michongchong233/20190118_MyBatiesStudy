package com.mickey.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mickey.dao.UserDao;
import com.mickey.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectAll() {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String user = "root";
		String userPassword = "1234";
		String sql = "select * from T41_UserImformation";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, userPassword);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setGender(rs.getByte(4));
				u.setAge(rs.getInt(5));
				userList.add(u);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public int createUser(String uname, String password, byte gender, int age) {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		String user = "root";
		String userPassword = "s70103ss";
		String sql = "insert into T41_UserImformation(uname, password, gender, age) values (?, ?, ?, ?);";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int updateNum = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, userPassword);
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, password);
			ps.setByte(3, gender);
			ps.setInt(4, age);
			updateNum = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateNum;
	}
}
