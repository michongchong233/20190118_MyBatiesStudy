package com.mickey.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class T11_TryBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("execution beforeAdvice");
		System.out.println("���I��k��H�Aarg0�G" + arg0 + "�F��k�W�G" + arg0.getName());
		System.out.print("���I��k�ѼơAarg1�G" + arg1 + "�ǤJ���ѼơG");
		for (Object str : arg1)
			System.out.print(str + ",");
		System.out.println("\n�եΤ��I��k��H�Aarg2�G" + arg2);
	}
}
