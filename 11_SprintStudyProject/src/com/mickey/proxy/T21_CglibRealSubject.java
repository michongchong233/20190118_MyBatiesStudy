package com.mickey.proxy;

/*
 * 使用cglib的動態代理，真實對象
 */
public class T21_CglibRealSubject {
	public void dealTask(String taskName) {
		System.out.println("Real_執行任務名為：" + taskName);
	}
}
