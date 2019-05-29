package com.mickey.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_t05_department")
public class T06_Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;
	private String location;

	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "did")
	private Set<T06_Employee> employees;

	public void addEmployee(T06_Employee employee) {
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

	public Set<T06_Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<T06_Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "T06_Department [did=" + did + ", dname=" + dname + ", location=" + location + "]";
	}

	public T06_Department(int did, String dname, String location, Set<T06_Employee> employees) {
		super();
		this.did = did;
		this.dname = dname;
		this.location = location;
		this.employees = employees;
	}

	public T06_Department() {
		super();
		this.employees = new HashSet<T06_Employee>();
	}

}
