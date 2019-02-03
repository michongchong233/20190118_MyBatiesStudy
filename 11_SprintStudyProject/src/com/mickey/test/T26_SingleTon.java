package com.mickey.test;

/*
 * 單例設計模式，餓漢式
 */
public class T26_SingleTon {
	//在類加載時就進行實例化
	private static T26_SingleTon singleTon;

	private T26_SingleTon() {}

	public static T26_SingleTon getInstance() {
		return singleTon;
	}
}
