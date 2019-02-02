package com.mickey.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * �ϥ�Schema-based����gĳ���`�q���A�H�U��ؤ�k�i�ܤ@�ϥ�
 */
public class T14_TryExceptionAdvice implements ThrowsAdvice {
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("ExceptionAdvice for Schema-based" + ex.getMessage());
	}
	
//	public void afterThrowing(Method m, Object[] args, Object target, ServletException ex) {
//        // Do something with all arguments
//    }
}
