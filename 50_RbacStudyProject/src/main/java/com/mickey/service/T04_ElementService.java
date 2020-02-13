package com.mickey.service;

import java.util.List;

import com.mickey.pojo.T04_Element;

public interface T04_ElementService {
	/**
	 * 取得此用戶的頁面權限
	 * @param uid
	 * @return
	 */
	public List<T04_Element> getElementList(int uid);
}
