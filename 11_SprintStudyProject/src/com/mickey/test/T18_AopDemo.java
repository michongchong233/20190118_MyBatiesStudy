package com.mickey.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component("T18_AopDemo")
public class T18_AopDemo {

	public T18_AopDemo() {
		super();
		System.out.println("調用T11_AopDemo無參構造器");
	}

	/**
	 * 測試無參的方法切點
	 */
	@Pointcut("execution(* com.mickey.test.T18_AopDemo.*(..))")//定義切點
	public void demo_01() {
		System.out.println("執行demo_01()主體內容");
	}

	/**
	 * 測試有參的方法切點
	 */
	public void demo_02(int id, String name) {
		System.out.println("執行demo_01()主體內容: " + id + " " + name);
	}

	/**
	 * 測試無設置切點的方法
	 */
	public void demo_03() {
		System.out.println("執行demo_03()主體內容");
	}

	/**
	 * 測試有返回值的切點
	 */
	public String demo_04(String name) {
		System.out.println("執行demo_04()主體內容");
		return name;
	}

	/**
	 * 測試異常通知
	 */
	@Pointcut("execution(* com.mickey.test.T18_AopDemo.*(..))")
	public void demo_05() throws Exception {
		int i = 5 / 0;
		System.out.println("執行demo_05()主體內容");
	}
	
	/**
	 * 測試環繞通知
	 */
	public void demo_06() {
		System.out.println("執行demo_06()主體內容");
	}
	

}
