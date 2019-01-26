package com.mickey.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mickey.mapper.T23_UserMapper;
import com.mickey.pojo.User;
import com.mickey.util.T25_MyBatiesUtil;

/**
 * �ǲߨϥ�ThreadLocal�إ�myBatiesUtil�èϥ�
 */
public class T25_UseMyBatiesUtil {
	public static void main(String[] args) {
		SqlSession session = T25_MyBatiesUtil.getSqlSession();//�p�G�qServlet�i�Ӫ��ܫh���μg�o�@�y�A�]��filter�w�g���F
		T23_UserMapper um = session.getMapper(T23_UserMapper.class);
		List<User> users = um.selectAll();
		users.stream().forEach(u->System.out.println(u.toString()));
	}
}
