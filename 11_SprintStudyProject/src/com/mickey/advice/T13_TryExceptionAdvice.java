package com.mickey.advice;

/**
 * �ϥ�AspectJ����gĳ���`�q��
 */
public class T13_TryExceptionAdvice /* implements ThrowsAdvice */ {
	public void myException(Exception e) {
		System.out.println("ExceptionAdvice for AspactJ; " + e.getMessage());
	}

	public T13_TryExceptionAdvice() {
		super();
		System.out.println("�ե�T13_TryExceptionAdvice�L�Ѻc�y��k");
	}

//	public void afterThrowing(Exception ex) throws Throwable {
//        System.out.println("ExceptionAdvice");
//    }
}
