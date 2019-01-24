package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.mapper.T23_UserMapper;
import com.mickey.pojo.User;

/**
 * ���ըϥ�getMapper���f�j�w�B�h�Ѽƶǻ�
 */
public class T23_TryMyBatiesGetMapper {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		//T23_UserMapper���f�Q��ҤơG�ݭn�����f�@�ӹ�Ҥƹ�H(�h��)�A�ϥ�JDK�������U�z�]�p�Ҧ�
		T23_UserMapper um = session.getMapper(T23_UserMapper.class);
		
		//�d�ߥ����Τ�H��
		List<User> users = um.selectAll();
		users.stream().forEach(u->System.out.println(u.toString()));
		
//		//�ھ�uid�Muname�d�ߥΤ�
//		User user = um.selectById(4, "mickey");
//		System.out.println(user!=null?user.toString():"�d�L���Τ�");
	}
}
