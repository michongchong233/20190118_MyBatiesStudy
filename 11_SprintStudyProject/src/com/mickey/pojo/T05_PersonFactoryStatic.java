package com.mickey.pojo;

public class T05_PersonFactoryStatic {
	public static T04_Person createPerson(String type) {
		T04_Person per;
		switch(type){
			case "A":
				//�i�g�������޿�
				per = new T05_PersonExtendsA();
				break;
			case "B":
				//�i�g�������޿�
				per = new T05_PersonExtendsB();
				break;
			default:
				//�i�g�������޿�
				per = null;
		}
		return per;
	}

}
