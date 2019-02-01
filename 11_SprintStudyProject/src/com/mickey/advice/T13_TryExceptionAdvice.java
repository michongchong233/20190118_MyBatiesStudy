package com.mickey.advice;

public class T13_TryExceptionAdvice /* implements ThrowsAdvice */ {
	public void myException(Exception e) {
		System.out.println("ExceptionAdvice; " + e.getMessage());
	}

//	public void afterThrowing(Exception ex) throws Throwable {
//        System.out.println("ExceptionAdvice");
//    }
}
