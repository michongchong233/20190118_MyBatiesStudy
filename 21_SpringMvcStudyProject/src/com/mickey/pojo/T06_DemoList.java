package com.mickey.pojo;

import java.util.List;

public class T06_DemoList {
	private List<T05_People> peos;

	public List<T05_People> getPeos() {
		return peos;
	}

	public void setPeos(List<T05_People> peos) {
		this.peos = peos;
	}

	@Override
	public String toString() {
		return "T06_DemoList [peos=" + peos + "]";
	}
	
}
