package com.mickey.test;

/**
 *ThreadLocal�G�u�{�e���A���u�{�j�w�@��Object���e
 */
public class T25_TryThreadLocal {
	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("�u�{�e���ǲ�");
		
		new Thread() {
			public void run() {
				System.out.println("Thread: "+tl.get());//�b���P�u�{���L�k���X�ƭ�
			};
		}.start();
		System.out.println("main: "+tl.get());
	}
}
