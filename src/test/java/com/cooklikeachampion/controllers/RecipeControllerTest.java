package com.cooklikeachampion.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cooklikeachampion.models.Recipe;


class RecipeControllerTest {
	RecipeController recipeController;

	@BeforeEach
	void setUp() {
		recipeController = new RecipeController();
		recipeController.init();
	}
	
	@Test
    public void testAddRecipe() {
        recipeController.setRecipeTitle("Test Recipe");
        recipeController.setRecipeText("This is a test recipe.");
        recipeController.setAgeGroup("8-11");

        assertEquals(null, recipeController.addRecipe());
        
        // Verify that the recipe has been added to the recipeList
        assertEquals(7, recipeController.getRecipeList().size());

        // Verify the details of the added recipe
        Recipe addedRecipe = recipeController.getRecipeList().get(6);
        assertEquals("Test Recipe", addedRecipe.getRecipeTitle());
        assertEquals("This is a test recipe.", addedRecipe.getRecipeText());
        assertEquals("8-11", addedRecipe.getAgeGroup());
        // Reset the fields for subsequent tests
        recipeController.setRecipeTitle(null);
        recipeController.setRecipeText(null);
        recipeController.setAgeGroup(null);
    }

	@Test   // test the number of total recipes in the list
	void testGetAllRecipesInList() {
		assertEquals(6, recipeController.getRecipeList().size());
	}
	@Test // test the number of recipes for 8-11 year-old kids
	void test8_11RecipesInList() {
		assertEquals(2, recipeController.getRecipeList8_11().size());
	}
	@Test   // test the number of recipes for 12-14 year-old kids
	void test12_14RecipesInList() {
		assertEquals(2, recipeController.getRecipeList12_14().size());
	}

	@Test    // test the number of recipes for 15-16 year-old kids
	void test15_16RecipesInList() {
		assertEquals(2, recipeController.getRecipeList15_16().size());
	}

	@Test
	public void testRecipeTitleGetterAndSetter() {
		String expectedTitle = "Veggie Burgers";
		recipeController.setRecipeTitle(expectedTitle);
		String actualTitle = recipeController.getRecipeTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	@Test
	public void testRecipeTextGetterAndSetter() {
		String expectedText = "Buy Ingredients. Mix together. Done";
		recipeController.setRecipeText(expectedText);
		String actualText = recipeController.getRecipeText();
		assertEquals(expectedText, actualText);
	}
	@Test
	public void testRecipeAgeGroupGetterAndSetter() {
		String expectedText = "15-16";
		recipeController.setAgeGroup(expectedText);
		String actualText = recipeController.getAgeGroup();
		assertEquals(expectedText, actualText);
	}
	@Test
	public void testRecipeCanEdit() {

		Recipe recipe = new Recipe("Flapjacks", "Combine the ingredients and viola", "8-11");

		recipeController.editRecipe(recipe);
		assertTrue(recipe.isCanEdit());
	}

	@Test   // test deleting recipe from the list
	void testDeleteRecipeFromList() {
		recipeController.init();
		Recipe recipe = new Recipe("Flapjacks", "Combine the ingredients and viola", "8-11");
		recipeController.recipeList.add(recipe);
		assertEquals(7, recipeController.getRecipeList().size());
		recipeController.deleteRecipe(recipe);
		assertEquals(6, recipeController.getRecipeList().size());

	}
	@Test
	void testSaveAction() {
		recipeController.init();
		Recipe recipe = new Recipe("Flapjacks", "Combine the ingredients and viola", "8-11");
		recipeController.recipeList.add(recipe);

		recipeController.editRecipe(recipe);
		assertTrue(recipe.isCanEdit());

		recipeController.saveAction();
		assertFalse(recipe.isCanEdit());
	}
}
