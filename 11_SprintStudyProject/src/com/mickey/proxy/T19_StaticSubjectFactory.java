package com.mickey.proxy;

/*
 * �R�A�N�z���u�t�A�Ȥ����եΦ��u�t��k��o�N�z��H
 * ��Ȥ����ӻ��A��}�����D��^���O�N�z����H�٬O�e������H
 */
public class T19_StaticSubjectFactory {
	public static T19_StaticSubject getSubject() {
		return new T19_StaticProxySubject(new T19_StaticRealSubject());
	}
}
