package com.mickey.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * �ϥ�JDK�ۥN���ʺA�N�z�A�N�z��
 */
public class T20_JdkProxySubject implements InvocationHandler{
	T20_JdkRealSubject real = new T20_JdkRealSubject();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("Proxy_�B��N�z����k");
		//�b����u���H����k�e��i�H�i��������޿�
		result = method.invoke(real, args);
		System.out.println("Proxy_�N�z����k�B�槹��");
		return result;
	}

}
