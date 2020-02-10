package com.mickey.pojo;

import java.io.Serializable;

public class PK_02_ResultPK implements Serializable {// 必須繼承序列化接口
	private int stuId;
	private int subId;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

}
