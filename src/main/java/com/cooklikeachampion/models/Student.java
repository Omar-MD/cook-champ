package com.cooklikeachampion.models;

import java.util.ArrayList;
import java.util.Date;

public class Student {

	private String studentID;
	private String studentName;
	private String guardianName;
	private String contactNum;
	private String ageGroup;
	private ArrayList<Attendance> attendanceRecords;

	boolean canEdit;

	public Student(String studentID, String studentName, String guardianName, String contactNum, String ageGroup) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.guardianName = guardianName;
		this.contactNum = contactNum;
		this.ageGroup = ageGroup;

		attendanceRecords = new ArrayList<>();
        initializeAttendanceRecords();
	}

    // Initialise attendance records for each day (Monday to Saturday)
    private void initializeAttendanceRecords() {
        for (int i = 0; i < 6; i++) {
            Attendance attendance = new Attendance();
            attendanceRecords.add(attendance);
        }
    }

    public ArrayList<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    // Check-in method
    public String checkIn(int day) {
        Attendance attendance = attendanceRecords.get(day);
        if (attendance.getCheckIn() == null) {
            attendance.setCheckIn(new Date());
        }

        return null;
    }

    // Check-out method
    public String checkOut(int day) {
    	Attendance attendance = attendanceRecords.get(day);

        if (attendance.getCheckIn() != null && attendance.getCheckOut() == null) {
            attendance.setCheckOut(new Date());
        }

        return null;
    }

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", guardianName=" + guardianName
				+ ", contactNum=" + contactNum + ", ageGroup=" + ageGroup + "]";
	}
}
