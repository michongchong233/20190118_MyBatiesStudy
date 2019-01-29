package com.mickey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mickey.pojo.T27_Student;
import com.mickey.pojo.T31_Student;

public interface T34_MyBatisComment {
	@Select("select * from mybateis_t27_student")
	public List<T31_Student> selectAllStudent();
	
	@Insert("insert into mybateis_t27_student values (default, #{param1}, #{param2}, #{param3})")
	public int insertStudent(String name, int age, int tid);
	
	@Update("update mybateis_t27_student set name=#{param2} where id=#{param1}")
	public int updateStudent(int id, String name);
	
	@Delete("delete from mybateis_t27_student where id=#{param1}")
	public int deleteStudent(int id);
	
	@Results(value={ 
	    @Result(id=true,property="id",column="id"),
	    @Result(property="name",column="name"),
	    @Result(property="age",column="age"),
	    @Result(property="teacher",column="tid",many=@Many(select="com.mickey.mapper.T29_ResultMapTestMapper.selectById" ))
	})
	@Select("select * from mybateis_t27_student")
	List<T27_Student> selStuAndTea();
	
}
