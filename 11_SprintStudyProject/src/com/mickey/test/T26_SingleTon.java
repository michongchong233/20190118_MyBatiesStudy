package com.mickey.test;

/*
 * ��ҳ]�p�Ҧ��A�j�~��
 */
public class T26_SingleTon {
	//�b���[���ɴN�i���Ҥ�
	private static T26_SingleTon singleTon;

	private T26_SingleTon() {}

	public static T26_SingleTon getInstance() {
		return singleTon;
	}
}
