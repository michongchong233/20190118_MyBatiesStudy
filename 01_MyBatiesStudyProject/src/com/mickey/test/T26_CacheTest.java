package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.mapper.T23_UserMapper;
import com.mickey.pojo.User;

/*
 * �ǲ�MyBaties���ϥ�
 */
public class T26_CacheTest {
	public static void main(String[] args) throws IOException {
//		Connection conn = null;
//		conn.prepareStatement("sql");
//		conn.createStatement();
//		conn.prepareCall("sql");//�եΦs�x�L�{����k
		
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		T23_UserMapper um = session.getMapper(T23_UserMapper.class);
		um.selectAll();
		
		//�P�@��SqlSession��H�եΦP�@��<select>��ñ�ɡA�u���Ĥ@���X�ݼƾڮw�A�d�ߵ������d�ߵ��G�w�s��SqlSession�w�s��(���s)��
		um.selectAll();
		
		//�ϥΤ��P��select��ñ�N�O�ݩ󤣦P��statement
		List<User> users_cache = um.selectAll_Cache();
		session.close();
		
		//���ĭS�򥲶��O�P�@��SqlSession�A�_�h�P�@��<select>�٬O�|�d�߼ƾڮw
		//<cache readOnly="true"></cache>�N���s���Ŵ��ɨ�SqlSessionFactory(�G�Žw�s)
		//SqlSession�MSqlSessionFactory���w�s�Ŷ����@��(�ۤ��W��)
		//�bSqlSession������~�|�Nsql��JSqlSessionFactory���w�s��
		SqlSession session2 = factory.openSession();
		T23_UserMapper um2 = session2.getMapper(T23_UserMapper.class);
		um2.selectAll();
		
		session.close();
	}
}
