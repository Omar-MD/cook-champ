package com.cooklikeachampion.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cooklikeachampion.controllers.CampController;
import com.cooklikeachampion.controllers.LoginController;
import com.cooklikeachampion.models.Student;
import com.cooklikeachampion.utils.Helper;

@ManagedBean
@SessionScoped
public class StudentBookingBean {
	private String studentName, guardianName, contactNum, ageGroup;
	private boolean bookingConfirmed;
	private String bookingMessage;
	private Student newStudent;

	@PostConstruct
	public void init() {
		ageGroup = "8-11";
		bookingConfirmed = false;
		bookingMessage = "";
		newStudent = new Student("","","","","8-11");
	}

	public String canBook() {
		LoginController loginController = Helper.getBean("loginController", LoginController.class);
		CampController campController = Helper.getBean("campController", CampController.class);

		if (loginController.isUserCustomer()) {
			setGuardianName(loginController.getLoggedInUser().getName());
		}

		newStudent.setStudentName(studentName);
		newStudent.setGuardianName(guardianName);
		newStudent.setContactNum(contactNum);
		newStudent.setContactNum(contactNum);
		newStudent.setAgeGroup(ageGroup);
		
		
		
		if (campController.isCampFull(ageGroup)) {

			setBookingMessage("Sorry, camp group " + ageGroup + " is fully booked.");
			setBookingConfirmed(false);
			
			resetFields(); // Reset fields
			return null;
		}
		else {
			
			setBookingMessage("Reserved a space for " + studentName + " in camp group " + ageGroup + " successfully. "
					+ "Please complete payment to finish booking");
			
			resetFields(); // Reset fields
			return "payment.xhtml";
		}

	}

	public String bookStudent(){
		CampController campController = Helper.getBean("campController", CampController.class);
		
		if (campController.addStudent(newStudent)) {

			setBookingMessage(newStudent.getStudentName() + " has been added to the camp");
			setBookingConfirmed(true);
			bookingConfirmed = true;
			
			resetFields(); // Reset fields
			resetStudent();
			return null;

		} else if (campController.isCampFull(ageGroup)) {

			setBookingMessage("Sorry, camp group " + ageGroup + " is fully booked.");
			setBookingConfirmed(false);
			resetFields(); // Reset fields
			resetStudent();
			return null;
		}

		setBookingMessage("Sorry, camp is not active");
		setBookingConfirmed(false);
		resetFields(); // Reset fields
		resetStudent();
		return null;
	}
	
	public String resetBookingMessage() {
		setBookingMessage("");
		return null;
	}

	// Getters & Setters
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		newStudent.setStudentName(studentName);
		this.studentName = studentName;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		newStudent.setGuardianName(guardianName);
		this.guardianName = guardianName;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		newStudent.setContactNum(contactNum);
		this.contactNum = contactNum;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		newStudent.setAgeGroup(ageGroup);
		this.ageGroup = ageGroup;
	}

	public boolean isBookingConfirmed() {
		return bookingConfirmed;
	}

	public void setBookingConfirmed(boolean bookingConfirmed) {
		this.bookingConfirmed = bookingConfirmed;
	}

	public String getBookingMessage() {
		return bookingMessage;
	}

	public void setBookingMessage(String bookingMessage) {
		this.bookingMessage = bookingMessage;
	}
	
	private void resetFields() {
		studentName = "";
		guardianName = ""; 
		contactNum = ""; 
		ageGroup = "8-11";
	}
	
	private void resetStudent() {
		newStudent = new Student("","","","","8-11");
	}
	
}
