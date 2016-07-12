package com.financial.analisys.expenses.domain;

public class User {

	private String userId;
	private String userName;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String alias) {
		this.password = alias;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			return user.getUserId().equals(this.getUserId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(this.getUserId()) * 17;
	}
}