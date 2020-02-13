package com.mickey.pojo;

public class T05_Url {
	private int id;
	private String urlPath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	@Override
	public String toString() {
		return "T05_Url [id=" + id + ", urlPath=" + urlPath + "]";
	}

}
