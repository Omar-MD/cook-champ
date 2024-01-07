package com.cooklikeachampion.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cooklikeachampion.models.Student;

public class CampControllerTest {
	private CampController campController;

	@BeforeEach
	public void setUp() {
		campController = new CampController();
		campController.init();
	}

	@Test
	void testAddStudent() {
		Student firstStudent = new Student("8-11-01", "William Dupont", "Mary Dupont", "0876918824", "8-11");
		campController.addStudent(firstStudent);
		int studentIndex = campController.getStudentsByAgeGroup("8-11").indexOf(firstStudent);

		assertEquals("8-11-04", campController.getAllStudents().get(studentIndex).getStudentID());
	}

	@Test
	void testEditStudent() {
		Student firstStudent = new Student("8-11-01", "William Dupont", "Mary Dupont", "0876918824", "8-11");
		campController.addStudent(firstStudent);

		assertEquals(false, firstStudent.isCanEdit());
		campController.editStudent(firstStudent);
		assertEquals(true, firstStudent.isCanEdit());
		campController.saveAction();
		assertEquals(false, firstStudent.isCanEdit());
	}

	@Test
	void testDeleteStudent() {
		Student firstStudent = new Student("8-11-01", "William Dupont", "Mary Dupont", "0876918824", "8-11");
		campController.addStudent(firstStudent);

		assertEquals(true, campController.containsStudent(firstStudent));
		campController.deleteStudent(firstStudent);
		assertEquals(false, campController.containsStudent(firstStudent));
	}

	@Test
	void testSelectedDay() {
		assertEquals(false, campController.isDaySelected("Tuesday"));
		assertEquals(true, campController.isDaySelected("Monday"));

		assertEquals("Monday", campController.getSelectedDay());
		campController.setSelectedDay("Tuesday");
		assertEquals("Tuesday", campController.getSelectedDay());
	}

	@Test
	void testDaysOfWeek() {
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[] newDays = {"Monday"};

		assertEquals(true, Arrays.equals(campController.getDaysOfWeek(), days));
		campController.setDaysOfWeek(newDays);
		assertEquals(true, Arrays.equals(campController.getDaysOfWeek(), newDays));
	}

	@Test
	void testAgeGroups() {
		String[] ageGroups = {"8-11", "12-14", "15-16"};
		String[] newGroups = {"17-18"};

		assertEquals(true, Arrays.equals(campController.getAgeGroups(), ageGroups));
		campController.setAgeGroups(newGroups);
		assertEquals(true, Arrays.equals(campController.getAgeGroups(),newGroups));
	}

	@Test
	void testIsCampFull() {
		assertEquals(false, campController.isCampFull("8-11"));
	}

	@Test
	void testGetAllStudents() {
		ArrayList<Student> allStudents = new ArrayList<>();
		Student firstStudent = new Student("8-11-01", "William Dupont", "Mary Dupont", "0876918824", "8-11");
		allStudents.add(firstStudent);

		Student secondStudent = new Student("12-14-02", "Harry Styles", "Sheila Styles", "085365392", "12-14");
		allStudents.add(secondStudent);

		Student thirdStudent = new Student("15-16-03", "Joe Bloggs", "Bonnie Bloggs", "0897273684", "15-16");
		allStudents.add(thirdStudent);

		assertEquals(true, campController.getAllStudents().get(0).getStudentID().equals(allStudents.get(0).getStudentID()));
		assertEquals(true, campController.getAllStudents().get(campController.getAllStudents().size()-1).getStudentID().equals(allStudents.get(allStudents.size()-1).getStudentID()));
	}
}
