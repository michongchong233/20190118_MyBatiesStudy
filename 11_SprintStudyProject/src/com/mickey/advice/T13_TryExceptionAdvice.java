package com.mickey.advice;

/**
 * 使用AspectJ的方寫議異常通知
 */
public class T13_TryExceptionAdvice /* implements ThrowsAdvice */ {
	public void myException(Exception e) {
		System.out.println("ExceptionAdvice for AspactJ; " + e.getMessage());
	}

	public T13_TryExceptionAdvice() {
		super();
		System.out.println("調用T13_TryExceptionAdvice無參構造方法");
	}

//	public void afterThrowing(Exception ex) throws Throwable {
//        System.out.println("ExceptionAdvice");
//    }
}
