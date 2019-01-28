package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.pojo.T27_Student;

public class T29_ResultMapTest {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
//		session.selectList("com.mickey.mapper.T29_ResultMapTestMapper.selectAll").stream()
//				.forEach(t -> System.out.println(t.toString()));

		List<T27_Student> students = session.selectList("com.mickey.mapper.T29_ResultMapTestMapper.selectAllStu");
		students.stream().forEach(s->System.out.println(s.toString()));

	}
}
