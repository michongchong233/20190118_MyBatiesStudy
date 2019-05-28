package com.mickey.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity//將一個類聲明成一個實體Bean
@Table(name="hibernate_t06_user")//指定表名
public class T06_User {
	@Id//表示主鍵
	@Column(name="uid")//指定字段
	@GeneratedValue(strategy = GenerationType.IDENTITY)//聲明主鍵生成策略
	private int uid;
	
	@Column(name="uname")
	private String uname;
	
	@Column(name="uage")
	private int uage;
	
	@Column(name="ubirth")
	private LocalDate ubirth;
	//@Transient --> 表示在表裡面不會有相關的字段
	//@Fomula("(select count(*) from hibernate_t06_user)") --> 用一個查詢語句動態的生成一個類的屬性

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public LocalDate getUbirth() {
		return ubirth;
	}

	public void setUbirth(LocalDate ubirth) {
		this.ubirth = ubirth;
	}

	@Override
	public String toString() {
		return "T06_User [uid=" + uid + ", uname=" + uname + ", uage=" + uage + ", ubirth=" + ubirth + "]";
	}

}
