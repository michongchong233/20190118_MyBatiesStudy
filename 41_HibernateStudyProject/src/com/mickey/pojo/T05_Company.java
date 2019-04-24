package com.mickey.pojo;

public class T05_Company {
	private int cid;
	private String cname;
	private T05_Address address;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public T05_Address getAddress() {
		return address;
	}

	public void setAddress(T05_Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "T05_Company [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}

	public T05_Company(int cid, String cname, T05_Address address) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.address = address;
	}

	public T05_Company() {
		super();
	}

}
