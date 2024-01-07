package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {

	Student student1;

	@BeforeEach
	void setUp()  {
		//System.out.println("Initialising");
		student1 = new Student ("8-11-09","William Dupont","Mary Dupont", "0876918824", "8-11");
	}

	@Test
	void testStudentNameGetter() {
		String expected = "William Dupont";
		String actual = student1.getStudentName();
		assertEquals(expected, actual);

	}
	@Test
	void testStudentNameSetter() {
		String expected = "Joey Bloggs";
		student1.setStudentName(expected);
		String actual = student1.getStudentName();
		assertEquals(expected, actual);

	}
	@Test
	void testGuardianNameGetter() {
		String expected = "Mary Dupont";
		String actual = student1.getGuardianName();
		assertEquals(expected, actual);

	}

	@Test
	void testGuardianNameSetter() {
		String expected = "Joey Bloggs";
		student1.setGuardianName(expected);
		String actual = student1.getGuardianName();
		assertEquals(expected, actual);

	}

	@Test
	void testContactNum() {
		String expected = "0871234567";
		student1.setContactNum(expected);
		String actual = student1.getContactNum();
		assertEquals(expected, actual);
	}

	@Test
	void testStudentID() {
		String expected = "8-11-01";
		student1.setStudentID(expected);
		String actual = student1.getStudentID();
		assertEquals(expected, actual);
	}

	@Test
	void testCanEdit() {
		student1.setCanEdit(true);
		assertTrue(student1.isCanEdit());
	}

	@Test
	void testAgeGroup() {
		String expected = "8-11";
		student1.setAgeGroup(expected);
		String actual = student1.getAgeGroup();
		assertEquals(expected, actual);
	}

	@Test
	void testStudentToString() {
		assertEquals(
				"Student [studentID=8-11-09, "+
				"studentName=William Dupont, "+
				"guardianName=Mary Dupont, "+
				"contactNum=0876918824, ageGroup=8-11]",
				student1.toString());
	}

	@Test
	void testGetAttendanceRecords() {
		assertEquals(null, student1.getAttendanceRecords().get(0).getCheckIn());
		assertEquals(null, student1.getAttendanceRecords().get(0).getCheckOut());
		Date currentDateTime = new Date();
		student1.checkIn(0);
		student1.checkOut(0);
		assertEquals(currentDateTime, student1.getAttendanceRecords().get(0).getCheckIn());
		assertEquals(currentDateTime, student1.getAttendanceRecords().get(0).getCheckOut());
	}
}
