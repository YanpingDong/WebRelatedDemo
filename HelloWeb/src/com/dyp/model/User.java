package com.dyp.model;

public class User {
	private String userName = null;
	private String userId = null;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public User(String userName, String userId) {
		this.userName = userName;
		this.userId = userId;
	}

}
