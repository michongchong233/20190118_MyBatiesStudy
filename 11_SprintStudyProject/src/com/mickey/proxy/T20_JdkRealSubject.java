package com.mickey.proxy;

/*
 * �ϥ�JDK�ۥN���ʺA�N�z�A�u���H
 */
public class T20_JdkRealSubject implements T20_JdkSubject {

	@Override
	public void dealTask(String taskName) {
		System.out.println("Real_������ȦW���G" + taskName);
	}

}
