package com.mickey.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity//�N�@�����n�����@�ӹ���Bean
@Table(name="hibernate_t06_user")//���w��W
public class T06_User {
	@Id//��ܥD��
	@Column(name="uid")//���w�r�q
	@GeneratedValue(strategy = GenerationType.IDENTITY)//�n���D��ͦ�����
	private int uid;
	
	@Column(name="uname")
	private String uname;
	
	@Column(name="uage")
	private int uage;
	
	@Column(name="ubirth")
	private LocalDate ubirth;
	//@Transient --> ��ܦb��̭����|���������r�q
	//@Fomula("(select count(*) from hibernate_t06_user)") --> �Τ@�Ӭd�߻y�y�ʺA���ͦ��@�������ݩ�

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
