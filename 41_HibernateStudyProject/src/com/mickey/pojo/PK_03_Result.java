package com.mickey.pojo;

import java.io.Serializable;

public class PK_03_Result implements Serializable{
	private PK_03_Student student;
	private PK_03_Subject subject;
	private double source;

	public PK_03_Student getStudent() {
		return student;
	}

	public void setStudent(PK_03_Student student) {
		this.student = student;
	}

	public PK_03_Subject getSubject() {
		return subject;
	}

	public void setSubject(PK_03_Subject subject) {
		this.subject = subject;
	}

	public double getSource() {
		return source;
	}

	public void setSource(double source) {
		this.source = source;
	}

}
