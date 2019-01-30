package com.mickey.service;

import java.util.List;

import com.mickey.mapper.T08_StudentMapper;
import com.mickey.pojo.T08_Student;

public interface T08_StudentService {
	
	public T08_StudentMapper getStudentMapper();
	
	public List<T08_Student> selectAllStudent();
}
