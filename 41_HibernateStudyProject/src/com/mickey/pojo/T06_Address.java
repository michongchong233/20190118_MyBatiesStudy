package com.mickey.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_t05_address")
public class T06_Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;

	private String country;

	private String city;

	private String street;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address") // mappedBy代表映射關系由T05_Company的address屬性來維護
	@JoinColumn(name = "cid")
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
		return "T06_Address [aid=" + aid + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", company=" + company + "]";
	}

}
