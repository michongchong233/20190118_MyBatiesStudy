package com.mickey.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_t05_company")
public class T06_Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	private String cname;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aid")
	private T06_Address address;

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

	public T06_Address getAddress() {
		return address;
	}

	public void setAddress(T06_Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "T06_Company [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}

}
