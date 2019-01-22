package com.mickey.pojo;

import java.util.List;

public class T20_PageInfo {
	// 每頁顯示個數
	private int pageStart;

	// 一頁顯示幾個
	private int pageSize;

	// 總頁數
	private int pageTotal;

	//當前頁顯示的數據
	private List<?> list;

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + pageSize;
		result = prime * result + pageStart;
		result = prime * result + pageTotal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T20_PageInfo other = (T20_PageInfo) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (pageStart != other.pageStart)
			return false;
		if (pageTotal != other.pageTotal)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "T20_pageInfo [pageStart=" + pageStart + ", pageSize=" + pageSize + ", pageTotal=" + pageTotal
				+ ", list=" + list + "]";
	}

	public T20_PageInfo(int pageStart, int pageSize, int pageTotal, List<?> list) {
		super();
		this.pageStart = pageStart;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.list = list;
	}

	public T20_PageInfo() {
		super();
	}

}
