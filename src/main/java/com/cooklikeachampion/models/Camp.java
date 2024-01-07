package com.cooklikeachampion.models;

import java.util.ArrayList;

public class Camp {
	final int CAMP_SIZE_8_11 = 9, CAMP_SIZE_12_14 = 12, CAMP_SIZE_15_16 = 24;

	private ArrayList<Student> group8_11;
	private ArrayList<Student> group12_14;
	private ArrayList<Student> group15_16;
	private int student_count;

	public Camp() {
		group8_11 = new ArrayList<Student>();
		group12_14 = new ArrayList<Student>();
		group15_16 = new ArrayList<Student>();
	}

	public boolean addStudentToCamp(Student aStudent) {
		String studentID = "";

		switch (aStudent.getAgeGroup()) {
		case "8-11":
			if (isCampAgeGroupFull("8-11")) {
				return false;
			}
			student_count++;
			studentID = createStudentID(group8_11, "8-11");
			aStudent.setStudentID(studentID);
			group8_11.add(aStudent);
			return true;

		case "12-14":
			if (isCampAgeGroupFull("12-14")) {
				return false;
			}
			student_count++;
			studentID = createStudentID(group12_14, "12-14");
			aStudent.setStudentID(studentID);
			group12_14.add(aStudent);
			return true;

		case "15-16":
			if (isCampAgeGroupFull("15-16")) {
				return false;
			}
			student_count++;
			studentID = createStudentID(group15_16, "15-16");
			aStudent.setStudentID(studentID);
			group15_16.add(aStudent);
			return true;
		}

		return false;
	}

	public boolean removeStudent(Student aStudent) {
		if (group8_11.contains(aStudent)) {
			return group8_11.remove(aStudent);
		}

		if (group12_14.contains(aStudent)) {
			return group12_14.remove(aStudent);
		}

		if (group15_16.contains(aStudent)) {
			return group15_16.remove(aStudent);
		}

		return false;
	}

	public Student getStudent(Student student) {
		if (group8_11.contains(student)) {
			return group8_11.get(group8_11.indexOf(student));
		}

		if (group12_14.contains(student)) {
			return group12_14.get(group12_14.indexOf(student));
		}

		if (group15_16.contains(student)) {
			return group15_16.get(group15_16.indexOf(student));
		}

		return null;
	}

	private String createStudentID(ArrayList<Student> group, String ageGroup) {

		String idPrefix = (student_count < 10) ? "-0" : "-";
		return ageGroup + idPrefix + student_count;
	}

	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> allStudents = new ArrayList<Student>();
		allStudents.addAll(group8_11);
		allStudents.addAll(group12_14);
		allStudents.addAll(group15_16);
		return allStudents;
	}

	public ArrayList<Student> getStudentsInAgeGroup(String ageGroup) {
		switch (ageGroup) {
		case "8-11":
			return group8_11;

		case "12-14":
			return group12_14;

		case "15-16":
			return group15_16;
		}
		
		return new ArrayList<Student>();
	}

	public boolean isCampAgeGroupFull(String ageGroup) {
		switch (ageGroup) {
		case "8-11":
			return group8_11.size() >= CAMP_SIZE_8_11;

		case "12-14":
			return group12_14.size() >= CAMP_SIZE_12_14;

		case "15-16":
			return group15_16.size() >= CAMP_SIZE_15_16;
		}
		return false;
	}

	public boolean containsStudent(Student student) {

		if(group8_11.contains(student) || group12_14.contains(student) || group15_16.contains(student)) { 
			return true;
		}
		
		return false;
	}
}
