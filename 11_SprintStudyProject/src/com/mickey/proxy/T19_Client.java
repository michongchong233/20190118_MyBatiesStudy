package com.mickey.proxy;

/*
 * �R�A�N�z�A�Ȥ���
 */
public class T19_Client {
	public static void main(String[] args) {
		T19_StaticSubject proxy = T19_StaticSubjectFactory.getSubject();
		proxy.dealTask("����Y��taskName");
	}
}
