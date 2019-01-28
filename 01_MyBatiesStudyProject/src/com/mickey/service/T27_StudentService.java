package com.mickey.service;

import com.mickey.pojo.T27_PageInfo;

public interface T27_StudentService {
	public T27_PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr);
}
