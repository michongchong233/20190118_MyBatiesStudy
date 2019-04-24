package com.mickey.pojo;

import java.util.HashSet;
import java.util.Set;

public class T05_Department {
	private int did;
	private String dname;
	private String location;
	
	//在這個部門中的雇員(雙向關聯用)
	private Set<T05_Employee> employees;

	public void addEmployee(T05_Employee employee) {
		employees.add(employee);
	}
	
	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<T05_Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<T05_Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "T05_Department [did=" + did + ", dname=" + dname + ", location=" + location
				+ "]";
	}

	public T05_Department(int did, String dname, String location, Set<T05_Employee> employees) {
		super();
		this.did = did;
		this.dname = dname;
		this.location = location;
		this.employees = employees;
	}

	public T05_Department() {
		super();
		this.employees = new HashSet<T05_Employee>();
	}
	

}
