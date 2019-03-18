package com.mickey.pojo;

import java.io.Serializable;

/*
 * �b�p�X�D�䤤�A�D�䪺��������ҤƧǨҥL���f
 * �@��b�����ت�java bean���ɭԳ��|��{Serializable�o�Ӫű��f�A�S�O�O�b���������ؤ��A��ܥi�H�ǨҤ�
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
