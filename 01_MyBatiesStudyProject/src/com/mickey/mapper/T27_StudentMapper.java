package com.mickey.mapper;

import java.util.List;

import com.mickey.pojo.T27_PageInfo;
import com.mickey.pojo.T27_Student;

public interface T27_StudentMapper {
	public List<T27_Student> selectByPage(T27_PageInfo pi);

	public int selectCountByPageInfo(T27_PageInfo pi);
	
}
