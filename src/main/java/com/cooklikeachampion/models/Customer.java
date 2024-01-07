package com.cooklikeachampion.models;

import java.util.ArrayList;

//merge test

public class Customer extends User {

	private ArrayList<Student> myStudents = new ArrayList<>();
	private static int customerCount;

	public Customer(String customerName, String email, String password) {
		super(customerName, email, password);
		customerCount++;
	}

	public ArrayList<Student> getMyStudents() {
		return myStudents;
	}

	public void setMyStudents(ArrayList<Student> myStudents) {
		this.myStudents = myStudents;
	}

	public static int getCustomerCount() {
		return customerCount;
	}

	public static void resetCustomerCount() {
		customerCount = 0;
	}
}
