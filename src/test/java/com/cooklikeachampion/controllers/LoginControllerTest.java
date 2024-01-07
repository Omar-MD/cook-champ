package com.cooklikeachampion.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cooklikeachampion.models.Admin;
import com.cooklikeachampion.models.Customer;

public class LoginControllerTest {
	private LoginController loginController;

	@BeforeEach
	public void setUp() {
		loginController = new LoginController();
		loginController.init();
	}

	@Test
	void testRegisterCustomer() {
		// Valid customer info
		String name = "Omar";
		String email = "Omar@cook.ie";
		String password = "1234";

		assertEquals(true, loginController.registerCustomer(name, email, password));
		assertEquals(false, loginController.registerCustomer(name, email, password));
	}

	@Test
	void testLoginWithCustomer() {
		// Valid customer info
		String name = "Omar";
		String email = "Omar@hello.ie";
		String password = "1234";

		loginController.registerCustomer(name, email, password);

		assertEquals(true, loginController.login(email, password));
		assertEquals(false, loginController.login("Failing test", password));
	}

	@Test
	void testLoginWithAdmin() {
		// Valid admin info
		String email = "admin@cook.com";
		String password = "root";

		assertEquals(true, loginController.login(email, password));
		assertEquals(false, loginController.login("Failing test", password));
	}

	@Test
	void testIsUserAdmin() {
		// Valid customer info
		String name = "Admin";
		String email = "admin@cook.ie";
		String password = "root";

		Admin admin = new Admin(name, email, password);
		loginController.setLoggedInUser(admin);
		assertEquals(true, loginController.isUserAdmin());

		Customer customer = new Customer(name, email, password);
		loginController.setLoggedInUser(customer);
		assertEquals(false, loginController.isUserAdmin());
	}

	@Test
	void testIsUserCustomer() {
		// Valid customer info
		String name = "Admin";
		String email = "admin@cook.ie";
		String password = "root";

		Customer customer = new Customer(name, email, password);
		loginController.setLoggedInUser(customer);
		assertEquals(true, loginController.isUserCustomer());

		Admin admin = new Admin(name, email, password);
		loginController.setLoggedInUser(admin);
		assertEquals(false, loginController.isUserCustomer());
	}

	@Test
	void testGetLoggedInUser() {
		Admin admin = new Admin("Admin", "admin@cook.ie", "root");
		assertEquals(null, loginController.getLoggedInUser());
		loginController.setLoggedInUser(admin);
		assertEquals(admin, loginController.getLoggedInUser());
	}

	@Test
	void testSetLoggedInUser() {
		Admin admin = new Admin("Admin", "admin@cook.ie", "root");
		assertEquals(null, loginController.getLoggedInUser());
		loginController.setLoggedInUser(admin);
		assertEquals(admin, loginController.getLoggedInUser());
	}

	@Test
	void testGetResponseMsg() {
		assertEquals(null, loginController.getResponseMsg());
		loginController.setResponseMsg("Testing...");
		assertEquals("Testing...", loginController.getResponseMsg());
	}

	@Test
	void testSetResponseMsg() {
		assertEquals(null, loginController.getResponseMsg());
		loginController.setResponseMsg("Testing...");
		assertEquals("Testing...", loginController.getResponseMsg());
	}

	@Test
	public void testLogout() {
		String name = "Finn";
		String email = "Finn@cook.ie";
		String password = "password";


		assertEquals(true, loginController.registerCustomer(name, email, password));
		assertEquals(true, loginController.login(email, password));


		loginController.logout();


		assertEquals(null, loginController.getLoggedInUser());
		assertEquals(false, loginController.isLoggedIn());
	}
}
