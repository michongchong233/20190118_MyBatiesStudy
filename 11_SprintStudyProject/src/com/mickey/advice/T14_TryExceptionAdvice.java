package com.mickey.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * 使用Schema-based的方寫議異常通知
 */
public class T14_TryExceptionAdvice implements ThrowsAdvice {
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("ExceptionAdvice for Schema-based");
	}
}
