package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CustomerTest {

	Customer customer1;

	@BeforeEach
	void setUp() {
		customer1 = new Customer("", "", "");
	}

    @AfterEach
    void tearDown() {
        // Clean up the object after each test
        customer1 = null;
        Customer.resetCustomerCount();
    }


	@Test
	void testCustomerName() {
		String expected = "John Wick";
		customer1.setName(expected);
		String actual = customer1.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testEmail() {
		String expected = "john@thecontinental.com";
		customer1.setEmail(expected);
		String actual = customer1.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	void testPassword() {
		String expected = "iluvdogs";
		customer1.setPassword(expected);
		String actual = customer1.getPassword();
		assertEquals(expected, actual);
	}

	@Test
	void testGetMyStudents() {
		ArrayList<Student> myStudents = customer1.getMyStudents();
		assertEquals(0, myStudents.size());
	}

	@Test
	void testSetMyStudents() {
		ArrayList<Student> myStudents = new ArrayList<>();
		myStudents.add(new Student("A", "", "", "", ""));
		customer1.setMyStudents(myStudents);
		assertEquals(1, myStudents.size());
	}

	@Test
	void testCustomerCount() {
		assertEquals(1, Customer.getCustomerCount());
	}

	@Test
	void testCustomerToString() {
		customer1.setName("John Wick");
		customer1.setEmail("john@thecontinental.com");
		customer1.setPassword("iluvdogs");
		assertEquals("name: John Wick,"
				+" email: john@thecontinental.com,"
				+" password: iluvdogs",
				customer1.toString());
	}
}
