package com.mickey.pojo;

import java.util.List;

public class T27_PageInfo {
	private int pageSize;//每頁顯示數量
	private int pageStart;//開始顯示角標
	private int pageNumber;//頁碼
	private int total;//總頁數
	private List<?> list;
	private String sname;// 學生姓名
	private String tname;// 老師姓名

	public T27_PageInfo(int pageSize, int pageStart, int pageNumber, int total, List<?> list, String sname,
			String tname) {
		super();
		this.pageSize = pageSize;
		this.pageStart = pageStart;
		this.pageNumber = pageNumber;
		this.total = total;
		this.list = list;
		this.sname = sname;
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "T27_PageInfo [pageSize=" + pageSize + ", pageStart=" + pageStart + ", pageNumber=" + pageNumber
				+ ", total=" + total + ", list=" + list + ", sname=" + sname + ", tname=" + tname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + pageNumber;
		result = prime * result + pageSize;
		result = prime * result + pageStart;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + total;
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
		T27_PageInfo other = (T27_PageInfo) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (pageStart != other.pageStart)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public T27_PageInfo() {
		super();
	}

}
