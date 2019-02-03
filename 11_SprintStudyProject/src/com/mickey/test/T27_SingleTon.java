package com.mickey.test;

/*
 * 單例設計模式，懶漢式，對象只有在調用的時候才建立
 */
public class T27_SingleTon {
	// 不能讓其他類直接調用此變量，因此使用private
	private static T27_SingleTon singleTon = new T27_SingleTon();

	private T27_SingleTon() {}

	/*
	 * 實例方法，實例方法必須通過對象來調用 要設置方法為靜態方法(因為無法通過new來實例化對象)
	 */
	public static T27_SingleTon getInstance() {
		if (singleTon == null) {// 如果對象沒有被實例化過才new，否敗直接返回
			synchronized (T27_SingleTon.class) {// 在多線程訪問下，可能出現if同時成立的穩況，需添加鎖
				if (singleTon == null) {// 雙重驗證
					singleTon = new T27_SingleTon();
				}
			}
		}
		return singleTon;
	}
}
