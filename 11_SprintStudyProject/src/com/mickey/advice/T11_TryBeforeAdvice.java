package com.mickey.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class T11_TryBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("execution beforeAdvice");
		System.out.println("切點方法對象，arg0：" + arg0 + "；方法名：" + arg0.getName());
		System.out.print("切點方法參數，arg1：" + arg1 + "傳入的參數：");
		for (Object str : arg1)
			System.out.print(str + ",");
		System.out.println("\n調用切點方法對象，arg2：" + arg2);
	}
}
