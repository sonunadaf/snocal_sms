package com.snocal.sms.conf.core.dto;

public class AuthenticateDO {

	private String userName;
	private String password;

	public AuthenticateDO() {

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

	public void setPassword(String password) {
		this.password = password;
	}

}
