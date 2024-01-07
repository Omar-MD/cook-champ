package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Finish tests and then fix Id generation
public class CampTest {
	private Camp camp;
	private Student student;

	@BeforeEach
	public void setUp() {
		camp = new Camp();
		student = new Student(null, "William Dupont", "Mary Dupont", "0876918824", "8-11");
	}

	@Test
	public void TestAddStudentValidAgeGroup() {
		assertEquals(true, camp.addStudentToCamp(student));
		assertEquals(true, camp.containsStudent(student));
		
		student.setAgeGroup("12-14");
		assertEquals(true, camp.addStudentToCamp(student));
		assertEquals(true, camp.containsStudent(student));

		student.setAgeGroup("15-16");
		assertEquals(true, camp.addStudentToCamp(student));
		assertEquals(true, camp.containsStudent(student));
	}

	@Test
	public void TestAddStudentInvalidAgeGroup() {
		student.setAgeGroup("16-19");
		assertEquals(false, camp.addStudentToCamp(student));
		assertEquals(false, camp.containsStudent(student));
	}

	@Test
	public void TestAddStudentAgeGroupFull() {
		for(int i=0; i < 24; i++) {
			if(i < 9) {
				student.setAgeGroup("8-11");
				camp.addStudentToCamp(student);
			}

			if(i < 12) {
				student.setAgeGroup("12-14");
				camp.addStudentToCamp(student);
			}
			student.setAgeGroup("15-16");
			camp.addStudentToCamp(student);
		}
		student.setAgeGroup("8-11");
		assertEquals(false, camp.addStudentToCamp(student));
		student.setAgeGroup("12-14");
		assertEquals(false, camp.addStudentToCamp(student));
		student.setAgeGroup("15-16");
		assertEquals(false, camp.addStudentToCamp(student));
		student.setAgeGroup("17-18");
		assertEquals(false, camp.isCampAgeGroupFull("17-18"));
	}

	@Test
	public void TestAddStudentUniqueId() {
		assertEquals(true, camp.addStudentToCamp(student));
		assertEquals(true, camp.containsStudent(student));
		assertEquals("8-11-01", camp.getStudent(student).getStudentID());
	}

	@Test
	public void TestRemoveStudent() {
		camp.addStudentToCamp(student);
		assertEquals(true, camp.containsStudent(student));
		assertEquals(true, camp.removeStudent(student));
		assertEquals(false, camp.containsStudent(student));
		
		student.setAgeGroup("12-14");
		camp.addStudentToCamp(student);
		assertEquals(true, camp.containsStudent(student));
		assertEquals(true, camp.removeStudent(student));
		assertEquals(false, camp.containsStudent(student));

		student.setAgeGroup("15-16");
		camp.addStudentToCamp(student);
		assertEquals(true, camp.containsStudent(student));
		assertEquals(true, camp.removeStudent(student));
		assertEquals(false, camp.containsStudent(student));

		student.setAgeGroup("17-18");
		camp.addStudentToCamp(student);
		assertEquals(false, camp.containsStudent(student));
		assertEquals(false, camp.removeStudent(student));
	}

	@Test
	public void TestGetAllStudents() {
		ArrayList<Student> students = new ArrayList<>();
		students.add(student);

		camp.addStudentToCamp(student);
		assertEquals(true, camp.getAllStudents().equals(students));
	}

	@Test
	public void TestGetStudentsInAgeGroup() {
		ArrayList<Student> students = new ArrayList<>();
		students.add(student);

		student.setAgeGroup("8-11");
		camp.addStudentToCamp(student);
		assertEquals(true, camp.getStudentsInAgeGroup("8-11").equals(students));

		student.setAgeGroup("12-14");
		camp.addStudentToCamp(student);
		assertEquals(true, camp.getStudentsInAgeGroup("12-14").equals(students));

		student.setAgeGroup("15-16");
		camp.addStudentToCamp(student);
		assertEquals(true, camp.getStudentsInAgeGroup("15-16").equals(students));
		assertEquals(false, camp.getStudentsInAgeGroup("17-18").equals(students));

	}

	@Test
	public void TestGetStudent() {
		camp.addStudentToCamp(student);
		assertEquals("8-11-01", camp.getStudent(student).getStudentID());

		Student student2 = new Student("ds","sdds","sdds","988987","1223");
		student2.setAgeGroup("12-14");
		camp.addStudentToCamp(student2);
		assertEquals("12-14-02", camp.getStudent(student2).getStudentID());

		Student student3 = new Student("ds","sdds","sdds","988987","1223");
		student3.setAgeGroup("15-16");
		camp.addStudentToCamp(student3);
		assertEquals("15-16-03", camp.getStudent(student3).getStudentID());

		Student student4 = new Student("ds","sdds","sdds","988987","1223");
		camp.addStudentToCamp(student4);
		assertEquals(null, camp.getStudent(student4));
	}
}
