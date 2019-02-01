package com.mickey.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class T11_TryAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("execution afterAdvice");
		System.out.println("���I��k��^�ȡAarg0�G" + arg0 + "�F��k�W�G" + arg1.getName());
		System.out.println("���I��k��H�Aarg1�G" + arg1);
		System.out.println("���I��k�ѼơAarg2�G" + arg2);
		System.out.println("���I��k�Ҧb������H�Aarg3�G" + arg3);
	}

}
