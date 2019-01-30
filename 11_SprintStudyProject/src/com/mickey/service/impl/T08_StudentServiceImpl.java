package com.mickey.service.impl;

import java.util.List;

import com.mickey.mapper.T08_StudentMapper;
import com.mickey.pojo.T08_Student;
import com.mickey.service.T08_StudentService;

public class T08_StudentServiceImpl implements T08_StudentService {
	private T08_StudentMapper studentMapper;

	public T08_StudentMapper getStudentMapper() {
		return studentMapper;
	}

	public void setStudentMapper(T08_StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public List<T08_Student> selectAllStudent() {
		return studentMapper.selectAll();
	}
}
