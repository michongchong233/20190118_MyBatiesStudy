package com.mickey.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class T11_TryBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("execution beforeAdvice");
		System.out.println("ち翴よ猭癸禜arg0" + arg0 + "よ猭" + arg0.getName());
		System.out.print("ち翴よ猭把计arg1" + arg1 + "肚把计");
		for (Object str : arg1)
			System.out.print(str + ",");
		System.out.println("\n秸ノち翴よ猭癸禜arg2" + arg2);
	}
}
