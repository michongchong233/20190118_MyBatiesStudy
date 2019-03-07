package com.mickey.pojo;

public class T01_User {
	private int id;
	private String username;
	private String password;
	private String photo;
	private int downloadNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getDownloadNum() {
		return downloadNum;
	}

	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}

	@Override
	public String toString() {
		return "T01_User [id=" + id + ", username=" + username + ", password=" + password + ", photo=" + photo
				+ ", downloadNum=" + downloadNum + "]";
	}

	public T01_User(int id, String username, String password, String photo, int downloadNum) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.photo = photo;
		this.downloadNum = downloadNum;
	}

	public T01_User() {
		super();
	}

}
