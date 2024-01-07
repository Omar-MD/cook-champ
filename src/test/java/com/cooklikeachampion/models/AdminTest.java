package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminTest {

	Admin admin1;

	@BeforeEach
	void setUp() {
		admin1 = new Admin("", "", "");
	}

    @AfterEach
    void tearDown() {
        // Clean up the object after each test
        admin1 = null;
        Admin.resetAdminCount();
    }

	@Test
	void testCustomerName() {
		String expected = "Admin";
		admin1.setName(expected);
		String actual = admin1.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testEmail() {
		String expected = "admin@cook.com";
		admin1.setEmail(expected);
		String actual = admin1.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	void testPassword() {
		String expected = "root";
		admin1.setPassword(expected);
		String actual = admin1.getPassword();
		assertEquals(expected, actual);
	}

	@Test
	void testSuperAdmin() {
		admin1.setSuperAdmin(true);
		assertTrue(admin1.isSuperAdmin());
	}

	@Test
	void testAdminCount() {
		admin1.setSuperAdmin(true);
		assertEquals(1, Admin.getAdminCount());
	}

}
