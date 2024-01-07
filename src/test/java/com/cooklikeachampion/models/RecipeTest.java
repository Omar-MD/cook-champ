package com.cooklikeachampion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeTest {
	Recipe recipe1;
	@BeforeEach
	void setUp()  {
	 recipe1 = new Recipe("Flapjacks", "Combine the ingredients and viola", "8-11");
	}


	@Test
	public void testRecipeConstructor() {
		assertEquals("Flapjacks", recipe1.getRecipeTitle());
		assertEquals("Combine the ingredients and viola", recipe1.getRecipeText());
		assertEquals("8-11", recipe1.getAgeGroup());
	}
	@Test
	void testStudentNameGetter() {
		String expected = "Flapjacks";
		String actual = recipe1.getRecipeTitle();
		assertEquals(expected, actual);

	}
	@Test
	public void testChangeRecipeTitle(){
		recipe1.setRecipeTitle("Oat Biscuits");
		assertEquals("Oat Biscuits", recipe1.getRecipeTitle());
	}
	@Test
	public void testChangeRecipeText(){
		recipe1.setRecipeText("Stir Ingredients well");
		assertEquals("Stir Ingredients well", recipe1.getRecipeText());
	}
	@Test
	public void testChangeRecipeAgeGroup(){
		recipe1.setAgeGroup("12-14");
		assertEquals("12-14", recipe1.getAgeGroup());
	}

	@Test
	public void testChangeCanEdit(){
		recipe1.setCanEdit(true);
		assertTrue(recipe1.isCanEdit());
	}
}
