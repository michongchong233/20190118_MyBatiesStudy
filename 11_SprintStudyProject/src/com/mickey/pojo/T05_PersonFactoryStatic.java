package com.mickey.pojo;

public class T05_PersonFactoryStatic {
	public static T04_Person createPerson(String type) {
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
