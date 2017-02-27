package com.forio.login;

public class Login {

	private String username;
	private String password;

	public Login(String uName, String pass) {
		this.username = uName;
		this.password = pass;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
