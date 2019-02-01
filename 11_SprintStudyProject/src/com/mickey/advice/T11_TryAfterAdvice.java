package com.mickey.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class T11_TryAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("execution afterAdvice");
		System.out.println("切點方法返回值，arg0：" + arg0 + "；方法名：" + arg1.getName());
		System.out.println("切點方法對象，arg1：" + arg1);
		System.out.println("切點方法參數，arg2：" + arg2);
		System.out.println("切點方法所在類的對象，arg3：" + arg3);
	}

}
