package com.mickey.proxy;

import net.sf.cglib.proxy.Enhancer;

public class T21_Client {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(T21_CglibRealSubject.class);//設置真實類
		enhancer.setCallback(new T21_CglibProxySubject());//設置實例代理類
		T21_CglibRealSubject create = (T21_CglibRealSubject) enhancer.create();
		create.dealTask("執行某個taskName");
	}
}
