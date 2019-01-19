package com.mickey.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mickey.dao.UserDao;
import com.mickey.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public ArrayList<User> selectAll() {
		var url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
		var user = "root";
		var passowrd = "s70103ss";
		var sql = "select * from T41_UserImformation";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		var userList = new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, passowrd);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				var u = new User();
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
	public int createUser() {
		return 0;
	}

}
