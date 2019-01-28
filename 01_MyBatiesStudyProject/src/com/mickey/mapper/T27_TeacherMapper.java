package com.mickey.mapper;

import java.util.List;

import com.mickey.pojo.T27_Teacher;

public interface T27_TeacherMapper {
	public List<T27_Teacher> selectAll();
	
	public T27_Teacher selectById(int tid);
}
