package com.cooklikeachampion.models;

public class Recipe {

	private String recipeTitle;
	private String recipeText;
	private String ageGroup;

	boolean canEdit;

	public Recipe(String recipeTitle, String recipeText, String ageGroup) {
		this.recipeTitle = recipeTitle;
		this.recipeText = recipeText;
		this.ageGroup = ageGroup;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public String getRecipeText() {
		return recipeText;
	}

	public void setRecipeText(String recipeText) {
		this.recipeText = recipeText;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}




}
