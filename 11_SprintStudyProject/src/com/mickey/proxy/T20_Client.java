package com.mickey.proxy;

import java.lang.reflect.Proxy;

public class T20_Client {

	public static void main(String[] args) {
		// 在java中，每個類的類加載器都是一樣的，類加載器是負責將所有的類加載(單例)
		System.out.println(T20_Client.class.getClassLoader() == T20_JdkRealSubject.class.getClassLoader());
		// 方法內要傳入的參數：反射使用的類加載器，proxy需要實現哪此接口，要調用哪個類的invoke方法
		T20_JdkSubject newProxyInstance = (T20_JdkSubject) Proxy.newProxyInstance(T20_Client.class.getClassLoader(),
				new Class[] { T20_JdkSubject.class }, new T20_JdkProxySubject());
		newProxyInstance.dealTask("執行某個taskName");// 執行代理對象的dealTask()

	}

}
