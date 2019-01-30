package com.mickey.pojo;

public class T06_Goods {
	private String gname;
	private int price;

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "T06_Goods [gname=" + gname + ", price=" + price + "]";
	}

	public T06_Goods(String gname, int price) {
		super();
		this.gname = gname;
		this.price = price;
	}

	public T06_Goods() {
		super();
	}

}
