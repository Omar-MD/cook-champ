package com.cooklikeachampion.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cooklikeachampion.models.Admin;
import com.cooklikeachampion.models.Customer;
import com.cooklikeachampion.models.User;

@ManagedBean
@SessionScoped
public class LoginController {

	private ArrayList<User> customers;
	private ArrayList<User> admins;
	private String responseMsg;
	private User loggedInUser;
	private boolean loggedIn;

	@PostConstruct
	public void init() {
		// Admin Initialisation
		admins = new ArrayList<>();
		Admin firstAdmin = new Admin("admin", "admin@cook.com", "root");
		firstAdmin.setSuperAdmin(true);
		admins.add(firstAdmin);

		// Customer Initialisation
		customers = new ArrayList<>();
		Customer firstCustomer = new Customer("omar", "omar@duadu.com", "12345");
		customers.add(firstCustomer);
	}

	public boolean registerCustomer(String name, String email, String password) {
		// Validate Unique email
		if (isUniqueEmail(customers, email)) {
			Customer newCustomer = new Customer(name, email, password);
			customers.add(newCustomer);
			setResponseMsg("Successful registration");
			return true;
		}

		return false;
	}

	public boolean login(String email, String password) {

		// Admin login
		if (isAdminEmail(email)) {
			for (User admin : admins) {
				if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
					setLoggedInUser(admin);
					setLoggedIn(true);
					return true;
				}
			}
		}

		// Customer login
		for (User customer : customers) {
			if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
				setLoggedInUser(customer);
				setLoggedIn(true);
				return true;
			}
		}

		// Invalid login credentials
		return false;
	}

	public String logout() {
	    loggedIn = false;
	    loggedInUser = null;
	    return "home.xhtml?faces-redirect=true";
	}

	private boolean isAdminEmail(String email) {
		final String ADMIN_DOMAIN = "cook.com";
		final char AT = '@';

		String domain = email.substring(email.indexOf(AT) + 1, email.length());

		if (domain.equalsIgnoreCase(ADMIN_DOMAIN)) {
			return true;
		}

		return false;
	}

	private boolean isUniqueEmail(ArrayList<User> users, String email) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				setResponseMsg("Email is already in use");
				return false;
			}
		}
		return true;
	}

	// Getters and Setters
	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public boolean isUserAdmin() {
		return (loggedInUser instanceof Admin);
	}

	public boolean isUserCustomer() {
		return (loggedInUser instanceof Customer);
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
