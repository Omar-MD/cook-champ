package com.cooklikeachampion.beans;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.cooklikeachampion.controllers.LoginController;
import com.cooklikeachampion.utils.Helper;

@ManagedBean
@RequestScoped
public class RegisterBean {
	private String name, email, password, confirmPassword;

	// OWASP email validation
	private final String EMAIL_REGEXP = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	// Method to handle the register action
	public String doRegister() {

		if (validInput()) {
			LoginController loginController = Helper.getBean("loginController", LoginController.class);

			if (loginController.registerCustomer(name, email, password)) {
				// Redirect to the home.xhtml page
				return "login.xhtml";
			}

			message(loginController.getResponseMsg());
			return (null);
		}

		return (null);
	}

	// Simple input validation
	public boolean validInput() {

		if (name.trim().isEmpty() || email.trim().isEmpty()) {
			message("invalid input: name and email fields cannot be blank");
			return false;
		}

		if (!password.equals(confirmPassword)) {
			message("invalid input: passwords must match");
			return false;
		}

		if (password.length() < 5) {
			message("invalid input: password must be greater than 5 characters");
			return false;
		}

		if (!validEmail(email)) {
			message("invalid input: incorrect email format");
			return false;
		}

		return true;
	}

	public boolean validEmail(String email) {
		return Pattern.compile(EMAIL_REGEXP).matcher(email).matches();
	}

	private void message(String error) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage errorMessage = new FacesMessage(error);
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, errorMessage);
	}

	// Getters and setters for the fields
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword.trim();
	}
}
