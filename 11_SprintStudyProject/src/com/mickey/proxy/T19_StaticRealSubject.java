package com.mickey.proxy;

/*
 * 真實對象，真正執行任務的類，實現了抽象方法
 */
public class T19_StaticRealSubject implements T19_StaticSubject {
	@Override
	public void dealTask(String taskName) {
		System.out.println("Real_執行任務名為：" + taskName);
	};
}
