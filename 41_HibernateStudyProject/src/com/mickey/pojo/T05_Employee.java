package com.mickey.pojo;

public class T05_Employee {
	private int eid;
	private String ename;
	private T05_Department department;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public T05_Department getDepartment() {
		return department;
	}

	public void setDepartment(T05_Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "T05_Employee [eid=" + eid + ", ename=" + ename + ", department=" + department + "]";
	}

}
