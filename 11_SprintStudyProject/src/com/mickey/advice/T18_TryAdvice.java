package com.mickey.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("T18_TryAdvice")//相當於是設定<bean id="">，如果沒有參數，默認會把類名首字母變小寫
@Aspect
public class T18_TryAdvice {
	/*
	 * 前置通知
	 */
	@Before("com.mickey.test.T18_AopDemo.demo_01()")
	public void beforeAdviceAspectJ() {
		System.out.println("execution beforeAdvice for Component");
	}
	
	/*
	 * 前置通知，有參數
	 */
	public void beforeAdvice(int uid, String uname) {
		System.out.println("execution beforeAdvice for Component: " + uid + " " + uname);
	}

	/*
	 * 異常通知
	 */
	@AfterThrowing("com.mickey.test.T18_AopDemo.demo_01()")
	public void ExceptionAdvice() {
		System.out.println("execution ExceptionAdvice for Component");
	}

	/*
	 * 後置通知
	 */
	@After("com.mickey.test.T18_AopDemo.demo_01()")
	public void afterAdvice() {
		System.out.println("execution afterAdvice for AspectJ");
	}
	
	/*
	 * 後置通知，Retruning
	 */
	@AfterReturning("com.mickey.test.T18_AopDemo.demo_01()")
	public void afterAdviceReturning() {
		System.out.println("execution afterAdviceReturning for Component");
	}

	/*
	 * 環繞通知
	 */
	@Around("com.mickey.test.T18_AopDemo.demo_01()")
	public Object aroundAdvice(ProceedingJoinPoint p) throws Throwable {
		System.out.println("execution aroundAdvice before for Component");
		Object result = p.proceed();
		System.out.println("execution aroundAdvice after for Component");
		return result;
	}
	
}
