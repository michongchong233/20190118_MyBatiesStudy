package com.mickey.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * �ϥ�Schema-based����gĳ���`�q��
 */
public class T14_TryExceptionAdvice implements ThrowsAdvice {
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("ExceptionAdvice for Schema-based");
	}
}
