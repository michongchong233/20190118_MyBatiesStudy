package com.mickey.proxy;

/*
 * �u���H�A�u��������Ȫ����A��{�F��H��k
 */
public class T19_StaticRealSubject implements T19_StaticSubject {
	@Override
	public void dealTask(String taskName) {
		System.out.println("Real_������ȦW���G" + taskName);
	};
}
