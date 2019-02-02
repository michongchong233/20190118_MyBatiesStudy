package com.mickey.proxy;

/*
 * 靜態代理，客戶類
 */
public class T19_Client {
	public static void main(String[] args) {
		T19_StaticSubject proxy = T19_StaticSubjectFactory.getSubject();
		proxy.dealTask("執行某個taskName");
	}
}
