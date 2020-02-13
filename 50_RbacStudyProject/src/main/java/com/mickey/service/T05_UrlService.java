package com.mickey.service;

import java.util.List;

import com.mickey.pojo.T05_Url;

public interface T05_UrlService {
	/**
	 * 取得此用戶的url權限
	 * @param uid
	 * @return
	 */
	public List<T05_Url> getUrlList(int uid);
	
	/**
	 * 取得所有url
	 * @return
	 */
	public List<T05_Url> getAllUrl();
}
