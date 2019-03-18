package com.mickey.pojo;

import java.io.Serializable;

/*
 * 在聯合主鍵中，主鍵的類必須實例化序例他接口
 * 一般在鳥項目的java bean的時候都會實現Serializable這個空接口，特別是在分布式項目中，表示可以序例化
 */
public class T04_StudentId implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "T04_StudentId [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	public T04_StudentId(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public T04_StudentId() {
		super();
	}

}
