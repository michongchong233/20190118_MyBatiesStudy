package com.mickey.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 * 使用cglib的動態代理，代理類
 */
public class T21_CglibProxySubject implements MethodInterceptor {

	/*
	 * Method代表代理的方法，MethodProxy代表代理實現的方法
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		Object result = null;
		System.out.println("Proxy_運行代理類方法");
		//在執行真實對象的方法前後可以進行相應的邏輯
		result = arg3.invokeSuper(arg0, arg2);//代表執行代理類的父類方法，也就是真實類的方法
//		result = arg1.invoke(arg0, arg2);//代表執行真實類的子類方法，也就是代理類的方法，會死循環
//		result = arg3.invoke(arg0, arg2);//代表執行代理類的方法，會死循環
		System.out.println("Proxy_代理類方法運行完畢");
		return result;
	}

}
