package com.cooklikeachampion.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cooklikeachampion.models.Camp;
import com.cooklikeachampion.models.Student;

@ManagedBean
@SessionScoped
public class CampController {

	private Camp camp;
	private String selectedDay = "Monday";
	private String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	private String[] ageGroups = {"8-11", "12-14", "15-16"};
	private boolean revealStars;

	@PostConstruct
	public void init() {
		// Camp initialisation
		camp = new Camp();

		Student firstStudent = new Student("8-11-01", "William Dupont", "Mary Dupont", "0876918824", "8-11");
		camp.addStudentToCamp(firstStudent);

		Student secondStudent = new Student("12-14-01", "Harry Styles", "Sheila Styles", "085365392", "12-14");
		camp.addStudentToCamp(secondStudent);

		Student thirdStudent = new Student("15-16-01", "Joe Bloggs", "Bonnie Bloggs", "0897273684", "15-16");
		camp.addStudentToCamp(thirdStudent);
	}

	// Methods
	public boolean isDaySelected(String day) {
		return day.equals(selectedDay);
	}

	public boolean addStudent(Student student) {
		return camp.addStudentToCamp(student);
	}

	public String editStudent(Student student) {
		student.setCanEdit(true);
		return null;
	}

	public String deleteStudent(Student student) {
		camp.removeStudent(student);
		return null;
	}

	public String saveAction() {
		for (Student student : camp.getAllStudents()) {
			student.setCanEdit(false);
		}
		return null;
	}

	public boolean isCampFull(String ageGroup) {
		return camp.isCampAgeGroupFull(ageGroup);
	}

	public ArrayList<Student> getAllStudents() {
		return camp.getAllStudents();
	}

	public ArrayList<Student> getStudentsByAgeGroup(String ageGroup) {
		return camp.getStudentsInAgeGroup(ageGroup);
	}

	public boolean containsStudent(Student student) {
		for (Student campStudent : camp.getAllStudents()) {
			if(campStudent.equals(student)) {
				return true;
			}
		}
		return false;
	}
	
	public String revealSportsStars() {
		this.revealStars = true;
		return null;
	}

	// Getters & Setters
	public String getSelectedDay() {
		return selectedDay;
	}

	public void setSelectedDay(String selectedDay) {
		this.selectedDay = selectedDay;
	}

	public String[] getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(String[] daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public String[] getAgeGroups() {
		return ageGroups;
	}

	public void setAgeGroups(String[] ageGroups) {
		this.ageGroups = ageGroups;
	}

	public boolean isRevealStars() {
		return revealStars;
	}

	public void setRevealStars(boolean revealStars) {
		this.revealStars = revealStars;
	}
}
