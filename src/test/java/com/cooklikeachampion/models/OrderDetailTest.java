package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderDetailTest {
	
	OrderDetail order;
	
	@BeforeEach
	void setup() {
		order = new OrderDetail("Toy", 20.0f, 0.0f, 0.0f, 20.0f);
	}
	
	@Test
	void testProductName() {
		assertEquals("Toy", order.getProductName());
	}
	
	@Test
	void testSubtotal() {
		assertEquals("20.00", order.getSubtotal());
	}
	
	@Test
	void testShipping() {
		assertEquals("0.00", order.getShipping());
	}
	
	@Test
	void testTax() {
		assertEquals("0.00", order.getTax());
	}
	
	@Test
	void testTotal() {
		assertEquals("20.00", order.getTotal());
	}


}
