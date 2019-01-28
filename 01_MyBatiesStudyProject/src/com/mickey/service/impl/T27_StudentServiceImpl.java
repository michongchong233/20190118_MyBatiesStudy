package com.mickey.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mickey.mapper.T27_StudentMapper;
import com.mickey.mapper.T27_TeacherMapper;
import com.mickey.pojo.T27_PageInfo;
import com.mickey.pojo.T27_Student;
import com.mickey.pojo.T27_Teacher;
import com.mickey.service.T27_StudentService;
import com.mickey.util.T25_MyBatiesUtil;

public class T27_StudentServiceImpl implements T27_StudentService {

	//SQL����
//	public static void main(String[] args) throws IOException {
//		InputStream is = Resources.getResourceAsStream("myBaties.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
////		T27_TeacherMapper tm = session.getMapper(T27_TeacherMapper.class);
////		List<T27_Teacher> teachers = tm.selectAll();
////		teachers.stream().forEach(t -> System.out.println(t.toString()));
//
//		T27_PageInfo pi = new T27_PageInfo();
//		pi.setPageStart(2);
//		pi.setPageSize(3);
//		pi.setSname("_1");
//		pi.setTname("_1");
//		T27_StudentMapper sm = session.getMapper(T27_StudentMapper.class);
//		List<T27_Student> students = sm.selectByPage(pi);
//		students.stream().forEach(s -> System.out.println(s.toString()));
//		System.out.println(sm.selectCountByPageInfo(pi));
//	}

	@Override
	public T27_PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
		int pageSize = pageSizeStr != null && pageSizeStr != "" ? Integer.parseInt(pageSizeStr) : 2;
		int pageNumber = pageNumberStr != null && pageNumberStr != "" ? Integer.parseInt(pageNumberStr) : 1;
		SqlSession session = T25_MyBatiesUtil.getSqlSession();
		T27_StudentMapper sm = session.getMapper(T27_StudentMapper.class);
		T27_PageInfo pi = new T27_PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber - 1) * pageSize);
		pi.setTname(tname);//�d�ߦѮv�W�ٱ���
		pi.setSname(sname);//�d�߾ǥͦW�ٱ���
		
		//�[�����f�A�H�K�d�X�C�ӦѮv���H��
		T27_TeacherMapper tm = session.getMapper(T27_TeacherMapper.class);
		
		// �i��`���M���A�d�X�C�Ӿǥͩҹ������Ѯv�H��
		List<T27_Student> students = sm.selectByPage(pi);
		for (T27_Student student : students) {
			T27_Teacher teacher = tm.selectById(student.getTid());//�ξǥ�tid�d�X�������Ѯv�H��
			student.setTeacher(teacher);
		}
		pi.setList(students);
		int count = sm.selectCountByPageInfo(pi);
		pi.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pi;
	}

}
