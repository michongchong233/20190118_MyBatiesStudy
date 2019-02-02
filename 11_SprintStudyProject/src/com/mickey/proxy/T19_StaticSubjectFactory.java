package com.mickey.proxy;

/*
 * 靜態代理類工廠，客戶類調用此工廠方法獲得代理對象
 * 對客戶類來說，其并不知道返回的是代理類對象還是委托類對象
 */
public class T19_StaticSubjectFactory {
	public static T19_StaticSubject getSubject() {
		return new T19_StaticProxySubject(new T19_StaticRealSubject());
	}
}
