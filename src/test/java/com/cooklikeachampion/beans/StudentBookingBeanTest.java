package com.cooklikeachampion.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentBookingBeanTest {

	private StudentBookingBean studentBookingBean;

    @BeforeEach
    public void setUp() {
        studentBookingBean = new StudentBookingBean();
        studentBookingBean.init();
    }
	    
    @Test
    public void testGetStudentName() {
        studentBookingBean.setStudentName("John Doe");
        assertEquals("John Doe", studentBookingBean.getStudentName());
    }

    @Test
    public void testSetStudentName() {
        studentBookingBean.setStudentName("Jane Smith");
        assertEquals("Jane Smith", studentBookingBean.getStudentName());
    }

    @Test
    public void testGetGuardianName() {
        studentBookingBean.setGuardianName("Parent Name");
        assertEquals("Parent Name", studentBookingBean.getGuardianName());
    }
    
    @Test
    public void testSetGuardianName() {
        studentBookingBean.setGuardianName("Another Parent");
        assertEquals("Another Parent", studentBookingBean.getGuardianName());
    }

    @Test
    public void testGetContactNum() {
        studentBookingBean.setContactNum("1234567890");
        assertEquals("1234567890", studentBookingBean.getContactNum());
    }

    @Test
    public void testSetContactNum() {
        studentBookingBean.setContactNum("9876543210");
        assertEquals("9876543210", studentBookingBean.getContactNum());
    }
    
    @Test
    public void testGetAgeGroup() {
        studentBookingBean.setAgeGroup("12-14");
        assertEquals("12-14", studentBookingBean.getAgeGroup());
    }

    @Test
    public void testSetAgeGroup() {
        studentBookingBean.setAgeGroup("15-18");
        assertEquals("15-18", studentBookingBean.getAgeGroup());
    }
}
