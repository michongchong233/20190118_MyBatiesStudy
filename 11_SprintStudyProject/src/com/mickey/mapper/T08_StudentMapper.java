package com.mickey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T08_Student;

public interface T08_StudentMapper {
	@Select("select * from mybateis_t27_student")
	public List<T08_Student> selectAll();
}
