package com.cooklikeachampion.models;

public class Admin extends User {

	private boolean superAdmin;
	private static int adminCount;

	public Admin(String adminName, String email, String password) {
		super(adminName, email, password);
		adminCount++;
	}

	public static int getAdminCount() {
		return adminCount;
	}

	public static void resetAdminCount() {
		adminCount = 0;
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

}
