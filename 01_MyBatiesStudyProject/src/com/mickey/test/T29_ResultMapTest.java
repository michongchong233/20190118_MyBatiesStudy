package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.mapper.T34_MyBatisComment;
import com.mickey.pojo.T27_Student;

public class T29_ResultMapTest {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
//		session.selectList("com.mickey.mapper.T29_ResultMapTestMapper.selectAll").stream()
//				.forEach(t -> System.out.println(t.toString()));

//		List<T27_Student> students = session.selectList("com.mickey.mapper.T29_ResultMapTestMapper.selectAllStu");
//		students.stream().forEach(s->System.out.println(s.toString()));
		
//		List<T31_Teacher> teachers = session.selectList("com.mickey.mapper.T31_ForeignKeyMapper.selectAll");
//		teachers.stream().forEach(t->System.out.println(t.toString()));

//		List<T33_Teacher> teachers = session.selectList("com.mickey.mapper.T31_ForeignKeyMapper.selectAll_T33");
//		teachers.stream().forEach(t->System.out.println(t.toString()));
		
		//class 34
		T34_MyBatisComment mbc = session.getMapper(T34_MyBatisComment.class);
//		List<T31_Student> stus = mbc.selectAllStudent();//查詢
//		stus.stream().forEach(s->System.out.println(s.toString()));
		int updateNum = 0;
//		updateNum = mbc.insertStudent("testCommandInsert_1", 26, 1);//新增
//		updateNum = mbc.updateStudent(28, "testUpdate_233");//修改
//		updateNum = mbc.deleteStudent(28);//刪除
		
		List<T27_Student> stus = mbc.selStuAndTea();
		stus.stream().forEach(s->System.out.println(s.toString()));
		
		session.commit();
		System.out.println(updateNum);
		
	}
}
