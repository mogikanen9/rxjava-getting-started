package com.mogikanensoftware.rx.composition.bean;

public class User {

	private String userName;
	private String email;
	private SecurityRole role;

	public User(String userName, String email, SecurityRole role) {
		super();
		this.userName = userName;
		this.email = email;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SecurityRole getRole() {
		return role;
	}

	public void setRole(SecurityRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", role=" + role + "]";
	}

}
