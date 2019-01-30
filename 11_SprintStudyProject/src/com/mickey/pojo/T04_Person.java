package com.mickey.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class T04_Person {
	private int id;
	private String name;
	private Set<String> set;
	private List<String> list;
	private Map<String, String> map;
	private String[] strs;
	private T06_Goods goods;

	public T06_Goods getGoods() {
		return goods;
	}

	public void setGoods(T06_Goods goods) {
		this.goods = goods;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("調用T04_Person setId");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("調用T04_Person setName");
		this.name = name;
	}

	@Override
	public String toString() {
		return "T04_Person [id=" + id + ", name=" + name + ", set=" + set + ", list=" + list + ", map=" + map
				+ ", strs=" + Arrays.toString(strs) + ", goods=" + goods + "]";
	}

	public T04_Person(int id, String name) {
		super();
		System.out.println("調用T04_Person有參構造方法, class4");
		this.id = id;
		this.name = name;
	}

	public T04_Person(int id, String name, Set<String> set, List<String> list, Map<String, String> map, String[] strs,
			T06_Goods goods) {
		super();
		System.out.println("調用T04_Person有參構造方法");
		this.id = id;
		this.name = name;
		this.set = set;
		this.list = list;
		this.map = map;
		this.strs = strs;
		this.goods = goods;
	}

	public T04_Person() {
		super();
		System.out.println("調用T04_Person無參構造方法");
	}

}
