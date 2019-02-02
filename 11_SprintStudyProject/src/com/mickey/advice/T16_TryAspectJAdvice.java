package com.mickey.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class T16_TryAspectJAdvice {
	/*
	 * �e�m�q��
	 */
	public void beforeAdviceAspectJ() {
		System.out.println("execution beforeAdvice for AspectJ");
	}
	
	/*
	 * �e�m�q���A���Ѽ�
	 */
	public void beforeAdviceAspectJ_T17(int uid, String uname) {
		System.out.println("execution beforeAdvice for AspectJ: " + uid + " " + uname);
	}

	/*
	 * ��m�q��
	 */
	public void afterAdviceAspectJ() {
		System.out.println("execution afterAdvice for AspectJ");
	}
	
	/*
	 * ��m�q��
	 */
	public void afterAdviceReturningAspectJ() {
		System.out.println("execution afterAdviceReturning for AspectJ");
	}

	/*
	 * ��¶�q��
	 */
	public Object aroundAdviceAspectJ(ProceedingJoinPoint p) throws Throwable {
		System.out.println("execution aroundAdvice before for AspectJ");
		Object result = p.proceed();
		System.out.println("execution aroundAdvice after for AspectJ");
		return result;
	}
	
}
