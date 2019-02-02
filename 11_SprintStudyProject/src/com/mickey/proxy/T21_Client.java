package com.mickey.proxy;

import net.sf.cglib.proxy.Enhancer;

public class T21_Client {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(T21_CglibRealSubject.class);//�]�m�u����
		enhancer.setCallback(new T21_CglibProxySubject());//�]�m��ҥN�z��
		T21_CglibRealSubject create = (T21_CglibRealSubject) enhancer.create();
		create.dealTask("����Y��taskName");
	}
}
