package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

	User user1;

	@BeforeEach
	void setUp() {
		user1 = new Admin("", "", "");
	}

	@Test
	void testCustomerName() {
		String expected = "Joe";
		user1.setName(expected);
		String actual = user1.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testEmail() {
		String expected = "joe@gmail.com";
		user1.setEmail(expected);
		String actual = user1.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	void testPassword() {
		String expected = "password";
		user1.setPassword(expected);
		String actual = user1.getPassword();
		assertEquals(expected, actual);
	}


}
