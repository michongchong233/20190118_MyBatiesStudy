package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatiesTest {

	public static void main(String[] args) {
		InputStream is;
		try {
			is = Resources.getResourceAsStream("myBaties.xml");
			//SqlSessionFactory�A�ϥΤu�t�]�p�Ҧ�
			//SqlSessionFactoryBuilder()�A�c�ت̳]�p�Ҧ��A��Y�Ǥ�����������i���ҤƮɡA�i�H�q�L�c�تֳ̧t�a��Ҥƹ�H
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
