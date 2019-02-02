package com.mickey.proxy;

/*
 * 使用JDK自代的動態代理，真實對象
 */
public class T20_JdkRealSubject implements T20_JdkSubject {

	@Override
	public void dealTask(String taskName) {
		System.out.println("Real_執行任務名為：" + taskName);
	}

}
