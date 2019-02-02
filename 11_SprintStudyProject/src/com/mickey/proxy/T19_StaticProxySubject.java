package com.mickey.proxy;

/*
 * �R�A�N�z��
 */
public class T19_StaticProxySubject implements T19_StaticSubject{
	T19_StaticRealSubject real = new T19_StaticRealSubject();

	public T19_StaticProxySubject(T19_StaticRealSubject real) {
		super();
		this.real = real;
	}

	public T19_StaticProxySubject() {
		super();
	}

	//�N�ШD�������e��������A�O������e�᪺�ɶ�
	@Override
	public void dealTask(String taskName) {
		System.out.println("Proxy_�B��N�z����k");
		//�b����u���H����k�e��i�H�i��������޿�
		real.dealTask(taskName);
		System.out.println("Proxy_�N�z����k�B�槹��");
	}

}
