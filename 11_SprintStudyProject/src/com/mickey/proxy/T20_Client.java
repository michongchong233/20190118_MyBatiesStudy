package com.mickey.proxy;

import java.lang.reflect.Proxy;

public class T20_Client {

	public static void main(String[] args) {
		// �bjava���A�C���������[�������O�@�˪��A���[�����O�t�d�N�Ҧ������[��(���)
		System.out.println(T20_Client.class.getClassLoader() == T20_JdkRealSubject.class.getClassLoader());
		// ��k���n�ǤJ���ѼơG�Ϯg�ϥΪ����[�����Aproxy�ݭn��{�������f�A�n�եέ�������invoke��k
		T20_JdkSubject newProxyInstance = (T20_JdkSubject) Proxy.newProxyInstance(T20_Client.class.getClassLoader(),
				new Class[] { T20_JdkSubject.class }, new T20_JdkProxySubject());
		newProxyInstance.dealTask("����Y��taskName");// ����N�z��H��dealTask()

	}

}
