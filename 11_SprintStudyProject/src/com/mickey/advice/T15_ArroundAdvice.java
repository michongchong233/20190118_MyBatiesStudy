package com.mickey.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class T15_ArroundAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("ArroundAdvice-Before");
		Object result = arg0.proceed();//���A�եΤ��I�覡
		System.out.println("ArroundAdvice-After");
		return result;
	}
}
