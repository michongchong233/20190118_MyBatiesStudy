package com.mickey.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("T18_TryAdvice")//�۷��O�]�w<bean id="">�A�p�G�S���ѼơA�q�{�|�����W���r���ܤp�g
@Aspect
public class T18_TryAdvice {
	/*
	 * �e�m�q��
	 */
	@Before("com.mickey.test.T18_AopDemo.demo_01()")
	public void beforeAdviceAspectJ() {
		System.out.println("execution beforeAdvice for Component");
	}
	
	/*
	 * �e�m�q���A���Ѽ�
	 */
	public void beforeAdvice(int uid, String uname) {
		System.out.println("execution beforeAdvice for Component: " + uid + " " + uname);
	}

	/*
	 * ���`�q��
	 */
	@AfterThrowing("com.mickey.test.T18_AopDemo.demo_01()")
	public void ExceptionAdvice() {
		System.out.println("execution ExceptionAdvice for Component");
	}

	/*
	 * ��m�q��
	 */
	@After("com.mickey.test.T18_AopDemo.demo_01()")
	public void afterAdvice() {
		System.out.println("execution afterAdvice for AspectJ");
	}
	
	/*
	 * ��m�q���ARetruning
	 */
	@AfterReturning("com.mickey.test.T18_AopDemo.demo_01()")
	public void afterAdviceReturning() {
		System.out.println("execution afterAdviceReturning for Component");
	}

	/*
	 * ��¶�q��
	 */
	@Around("com.mickey.test.T18_AopDemo.demo_01()")
	public Object aroundAdvice(ProceedingJoinPoint p) throws Throwable {
		System.out.println("execution aroundAdvice before for Component");
		Object result = p.proceed();
		System.out.println("execution aroundAdvice after for Component");
		return result;
	}
	
}
