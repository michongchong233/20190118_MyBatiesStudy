package com.mickey.pojo;

public class T05_PersonFactory {
	//工廠只負責創建對象，無論多少層關系都可以進行管理
	//工廠設計模式：幫助創建類對象，一個工廠可以生産多個對象，需要先創建工廠才能建立對
	public T04_Person createPerson(String type) {
		T04_Person per;
		switch(type){
			case "A":
				//可寫相應的邏輯
				per = new T05_PersonExtendsA();
				break;
			case "B":
				//可寫相應的邏輯
				per = new T05_PersonExtendsB();
				break;
			default:
				//可寫相應的邏輯
				per = null;
		}
		return per;
	}
}
