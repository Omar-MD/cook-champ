package com.cooklikeachampion.models;

public abstract class User {

	private String name, email, password;

	User(String aName, String aEmail, String aPassword) {
		name = aName;
		email = aEmail;
		password = aPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "name: " + name + ", email: " + email + ", password: " + password;
	}
}
