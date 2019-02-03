package com.mickey.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class T24_User {
	@Value("${demo.name}")
	private String uname;
	@Value("${demo.password}")
	private String password;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "T24_User [uname=" + uname + ", password=" + password + "]";
	}
	
}
