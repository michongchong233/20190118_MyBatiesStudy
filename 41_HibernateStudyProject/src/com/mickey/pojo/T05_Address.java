package com.mickey.pojo;

public class T05_Address {
	private int aid;
	private String country;
	private String city;
	private String street;
	private T05_Company company;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public T05_Company getCompany() {
		return company;
	}

	public void setCompany(T05_Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "T05_Address [aid=" + aid + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", company=" + company + "]";
	}

	public T05_Address(int aid, String country, String city, String street, T05_Company company) {
		super();
		this.aid = aid;
		this.country = country;
		this.city = city;
		this.street = street;
		this.company = company;
	}

	public T05_Address() {
		super();
	}

}
