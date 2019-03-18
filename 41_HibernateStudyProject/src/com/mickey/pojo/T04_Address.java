package com.mickey.pojo;

public class T04_Address {
	private String city;
	private String street;
	private int zipcode;

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

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "T04_Address [city=" + city + ", street=" + street + ", zipcode=" + zipcode + "]";
	}

	public T04_Address(String city, String street, int zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	public T04_Address() {
		super();
	}

}
