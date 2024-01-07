package com.cooklikeachampion.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class AuthorizePaymentTest {
	
	AuthorizePayment auth;
	
	@BeforeEach
	void setUp() {
		auth = new AuthorizePayment();
	}
	
	@Test
	void testSetProduct() {
		auth.setProduct("Toy");
		assertEquals("Toy", auth.getProduct());
	}
	
	@Test
	void testSetShipping() {
		auth.setShipping(20.0f);
		assertEquals(20.0f, auth.getShipping());
	}
	
	@Test
	void testSetTax() {
		auth.setTax(10.0f);
		assertEquals(10.0f, auth.getTax());
	}
	
	@Test
	void testSetTotal() {
		auth.setTotal(30.0f);
		assertEquals(30.0f, auth.getTotal());
	}
	
	@Test
	void testSetSubtotal() {
		auth.setSubTotal(40.0f);
		assertEquals(40.0f, auth.getSubTotal());
	}

}
