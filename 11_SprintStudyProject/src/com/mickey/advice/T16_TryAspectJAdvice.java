package com.mickey.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class T16_TryAspectJAdvice {
	/*
	 * 前置通知
	 */
	public void beforeAdviceAspectJ() {
		System.out.println("execution beforeAdvice for AspectJ");
	}
	
	/*
	 * 前置通知，有參數
	 */
	public void beforeAdviceAspectJ_T17(int uid, String uname) {
		System.out.println("execution beforeAdvice for AspectJ: " + uid + " " + uname);
	}

	/*
	 * 後置通知
	 */
	public void afterAdviceAspectJ() {
		System.out.println("execution afterAdvice for AspectJ");
	}
	
	/*
	 * 後置通知
	 */
	public void afterAdviceReturningAspectJ() {
		System.out.println("execution afterAdviceReturning for AspectJ");
	}

	/*
	 * 環繞通知
	 */
	public Object aroundAdviceAspectJ(ProceedingJoinPoint p) throws Throwable {
		System.out.println("execution aroundAdvice before for AspectJ");
		Object result = p.proceed();
		System.out.println("execution aroundAdvice after for AspectJ");
		return result;
	}
	
}
