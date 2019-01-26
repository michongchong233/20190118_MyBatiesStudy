package com.mickey.test;

/**
 *ThreadLocal：線程容器，給線程綁定一個Object內容
 */
public class T25_TryThreadLocal {
	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("線程容器學習");
		
		new Thread() {
			public void run() {
				System.out.println("Thread: "+tl.get());//在不同線程中無法取出數值
			};
		}.start();
		System.out.println("main: "+tl.get());
	}
}
