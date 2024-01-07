package com.cooklikeachampion.beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.cooklikeachampion.controllers.LoginController;
import com.cooklikeachampion.utils.Helper;

@ManagedBean
@RequestScoped
public class LoginBean {
	private String email, password;

	// Methods
	public String doLogin() {
		LoginController loginController = Helper.getBean("loginController", LoginController.class);

		if (loginController.login(email, password)) {
			return "home.xhtml";
		}

		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Error: Invalid email and/or password");
		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		facesContext.addMessage(null, facesMessage);

		return (null);
	}

	 public String doLogout() {
	        FacesContext context = FacesContext.getCurrentInstance();
	        ExternalContext externalContext = context.getExternalContext();
	        LoginController loginController = Helper.getBean("loginController", LoginController.class);

	        try {
	            externalContext.redirect(loginController.logout());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	// Getters & Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}
}

