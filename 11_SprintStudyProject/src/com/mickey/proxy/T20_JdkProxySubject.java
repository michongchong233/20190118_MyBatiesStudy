package com.mickey.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * 使用JDK自代的動態代理，代理類
 */
public class T20_JdkProxySubject implements InvocationHandler{
	T20_JdkRealSubject real = new T20_JdkRealSubject();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("Proxy_運行代理類方法");
		//在執行真實對象的方法前後可以進行相應的邏輯
		result = method.invoke(real, args);
		System.out.println("Proxy_代理類方法運行完畢");
		return result;
	}

}
