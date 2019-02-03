package com.mickey.test;

/*
 * 單例設計模式，懶漢式，對象只有在調用的時候才建立
 */
public class T26_SingleTon {
	// 不能讓其他類直接調用此變量，因此使用private
	private static T26_SingleTon singleTon;

	/*
	 * 方法名和類名相同，並且無返回值 其他類不能實例化這個類的對象-->設為private 必須要對外提供訪問入口
	 */
	private T26_SingleTon() {
	}

	/*
	 * 實例方法，實例方法必須通過對象來調用 要設置方法為靜態方法(因為無法通過new來實例化對象)
	 */
	public static T26_SingleTon getInstance() {
		if (singleTon == null) {// 如果對象沒有被實例化過才new，否敗直接返回
			synchronized (T26_SingleTon.class) {// 在多線程訪問下，可能出現if同時成立的穩況，需添加鎖
				if (singleTon == null) {// 雙重驗證
					singleTon = new T26_SingleTon();
				}
			}
		}
		return singleTon;
	}
}
