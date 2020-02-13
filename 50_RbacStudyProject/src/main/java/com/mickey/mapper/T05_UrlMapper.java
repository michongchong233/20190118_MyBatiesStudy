package com.mickey.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mickey.pojo.T05_Url;

public interface T05_UrlMapper {
	
	@Results(value= {
			@Result(id = true, column = "id", property = "id"),
			@Result(column ="url_path", property = "urlPath")
	})
	@Select("select rbac_05_url.*, #{uid} uid " + 
			"from rbac_05_actor_url " + 
			"inner join rbac_05_url on rbac_05_actor_url.url_id = rbac_05_url.id " + 
			"where aid in(select aid from rbac_03_user_actor where uid=#{uid})")
	public List<T05_Url> selectByUid(int uid);

	@Results(value= {
			@Result(id = true, column = "id", property = "id"),
			@Result(column ="url_path", property = "urlPath")
	})
	@Select("select * from rbac_05_url")
	public List<T05_Url> selectAll();
}
