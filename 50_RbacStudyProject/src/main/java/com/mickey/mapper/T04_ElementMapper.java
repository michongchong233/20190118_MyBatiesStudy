package com.mickey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T04_Element;

public interface T04_ElementMapper {

	@Results(value= {
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "element_str", property = "elementStr")
	})
	@Select("select rbac_04_element.*, #{uid} uid " + 
			"from rbac_04_element " + 
			"inner join rbac_04_actor_element on rbac_04_actor_element.eid = rbac_04_element.id " + //
			"where aid in(select aid from rbac_03_user_actor where uid=#{uid});")
	public List<T04_Element> selectByUid(int uid);
}
