package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttendanceTest {

	Attendance attendance;

	@BeforeEach
	void setUp() {
		attendance = new Attendance();
	}

	@Test
	void testCheckIn() {
		assertEquals(null, attendance.getCheckIn());
		Date now = new Date();
		attendance.setCheckIn(now);
		assertEquals(now, attendance.getCheckIn());
	}

	@Test
	void testCheckOut() {
		assertEquals(null, attendance.getCheckOut());
		Date now = new Date();
		attendance.setCheckOut(now);
		assertEquals(now, attendance.getCheckOut());
	}
}