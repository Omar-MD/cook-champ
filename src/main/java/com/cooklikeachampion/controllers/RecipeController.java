package com.cooklikeachampion.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cooklikeachampion.models.Recipe;

@ManagedBean
@SessionScoped
public class RecipeController {
	private String recipeTitle;
	private String recipeText;
	private String ageGroup;

	ArrayList<Recipe> recipeList;

	@PostConstruct
	public void init() {
		// RecipeList initialisation
		recipeList = new ArrayList<>();

		Recipe firstRecipe = new Recipe("Rainbow Fruit Skewers",
				"A sweet yet healthy treat that looks and tastes delicious\n"
						+"Ingredients						Price	 Nutritional Content\n"
						+"Raspberries 						€1.20  - Antioxidants, Vitamin C\n"
						+"Strawberries hulled					€1.80  - Antioxidants, Vitamin C\n"
						+"Mandarin segments				€1.80  - Antioxidants, Vitamin C\n"
						+"1 Mango peeled and cubed			€1.80  - Antioxidants, Vitamin C\n"
						+"1 Pineapple cut in chunks			€1.80  - Antioxidants, Vitamin C\n"
						+"2 Kiwi Fruit (cut into chunks)			€1.80  - Antioxidants, Vitamin C\n"
						+"Green and Red Grapes				€1.80  - Antioxidants, Vitamin C\n"
						+"Blueberries						€1.80  - Antioxidants, Vitamin C\n"
						+ "Method\n"
						+ "STEP 1\n"
						+ "Take 7 wooden skewers and thread the following fruit onto each \n"
						+ "1 raspberry, 1 hulled strawberry, 1 mandarin segment,  \n "
						+ "1 cube of peeled mango, 1 chunk of peeled pineapple, \n "
						+ "1 chunk of peeled kiwi, 1 green and 1 red grape,  \n "
						+ "and finish off with 2 blueberries. Arrange in a rainbow  \n "
						+ "shape and let everyone help themselves. \n", "8-11");
		recipeList.add(firstRecipe);

		Recipe secondRecipe = new Recipe("Veggie Burgers",
				"Packed with flavour, these vegan corn burgers are healthy and seriously satisfying.\n"
						+ "\n"
						+ "Ingredients						Price	 Nutritional Content\n"
						+ "1 x 400 g tin of chickpeas			~€1.20	Protein, Manganese\n"
						+ "1 x 340 g tin of sweetcorn			~€1.30	Fiber, Thiamin\n"
						+ "½ a bunch of fresh coriander			~€0.90	Antioxidants, Vitamin A\n"
						+ "½ teaspoon paprika				~€0.30	Vitamin A\n"
						+ "½ teaspoon ground coriander			~€0.30	Phosphorus       \n"
						+ "½ teaspoon ground cumin			~€0.30	Selenium, Zinc\n"
						+ "1 lemon							~€0.50	Vitamin C\n"
						+ "1 small round lettuce				~€0.80	Iron, Vitamin C\n"
						+ "2 large ripe tomatoes				~€0.50	Potassium, Vitamin C\n"
						+ "4 wholemeal burger buns			~€0.30	Manganese, Phosphorus\n"
						+ "3 heaped tablespoons plain flour\n"
						+ "rapeseed oil\n"
						+ "tomato ketchup\n"
						+ "Full details of the recipe will be given on the course\n"
						+ "Book your child's place today!", "12-14");
		recipeList.add(secondRecipe);

		Recipe thirdRecipe = new Recipe("Vegetarian Shephards Pie",
				"Shephards Pie - but without the meat!\n"
						+ "Made with lentils and cremini mushrooms as well as the traditional \n"
						+ "carrots and peas, this vegetarian take on the traditional British \n"
						+ "potato-topped Shepherd's pie is satisfying and delicious. We use \n"
						+ "French green lentils because they hold their shape in cooking.\n"
						+ "\n"
						+ "Ingredients used					Price	 Nutritional Content\n"
						+ "2 tablespoons extra-virgin olive oil		~€0.30	Healthy fats\n"
						+ "1 large onion, finely diced			~€0.40	Vitamins, Minerals\n"
						+ "2 carrots, peeled, thinly sliced			~€0.30	Fiber, Vitamins A,K\n"
						+ "2 celery stalks, thinly sliced			~€0.20	Folate, Vitamins A,K\n"
						+ "300g cremini mushrooms, sliced		~€2.20	Calcium, Protein\n"
						+ "1 tablespoon tomato paste			~€0.50	Vitamin C\n"
						+ "1 tablespoon Worcestershire sauce	~€0.10	Vitamin C\n"
						+ "1 cup French green lentils			~€0.90	Niacin, Protein\n"
						+ "Sea salt and ground pepper			~€0.10	Vitamin C, Iron\n"
						+ "1 cup frozen peas 					~€0.10	Potassium, Protein\n"
						+ "1 kg potatoes, cut in chunks			~€3.00	Fiber, Vitamin B6\n"
						+ "4 cloves garlic						~€0.50	Potassium\n"
						+ "4 tablespoons unsalted butter			~€0.40\n"
						+ "½ cup whole milk, warmed			~€0.40\n"
						+ "1 dried bay leaf					~€0.10\n "
						+ "Full details of the recipe will be given on the course\n"
						+ "Book your child's place today!", "15-16" );
		recipeList.add(thirdRecipe);
		Recipe fourthRecipe = new Recipe("Black Bean Quesadillas",
				"These satisfying quesadillas take just 15 minutes to make. \n"
						+ "We make them with black beans, but pinto beans work well too. \n"
						+ "If you like a little heat, be sure to use pepper Jack cheese in the filling. \n"
						+ "Serve with: A little sour cream and a mixed green salad.\n"
						+ "\n"
						+ "Ingredients						Price	Nutritional Content\n"
						+ "1  400g can black beans, rinsed		~€2.20	Calcium, Protein\n"
						+ "½ cup shredded cheese 				~€1.20	Calcium, Protein\n"
						+ "1/2 cup prepared fresh salsa 			~€1.90	Vitamin C, Protein\n"
						+ "4 20cm whole-wheat tortillas			~€1.90	Manganese, Phosphorus\n"
						+ "1 ripe avocado, diced 				~€1.10	Vitamin E, Potassium\n"
						+ "2 teaspoons olive oil\n"
						+ "Full details of the recipe will be given on the course\n"
						+ "Book your child's place today!"
						, "8-11" );
		recipeList.add(fourthRecipe);
		Recipe fifthRecipe = new Recipe("Tuna and Salad Mini Wraps",
				"For some lunchtime inspiration, make these colourful wraps for the family\n"
						+ "\n"
						+ "Ingredients						Price	Nutritional Content\n"
						+ "200g can tuna, drained				~€1.40	DHA, Protein\n"
						+ "125g plain yoghurt					~€1.20	Calcium, Protein\n"
						+ "40g mixed lettuce leaves			~€1.20	Iron, Vitamin C\n"
						+ "1 tomato, finely chopped				~€0.40	Vitamin C\n"
						+ "1 tbsp chopped fresh chives			~€0.60	Choline, Folate\n"
						+ "1 tbsp chopped basil leaves			~€0.60	Lutein, Vitamin A\n"
						+ "1 celery stalk, finely chopped			~€0.30	Potassium, Vitamin K\n"
						+ "2 sheets wholemeal lavash bread		~€1.60	Calcium\n"
						+ "Full details of the recipe will be given on the course\n"
						+ "Book your child's place today!"
						, "12-14" );
		recipeList.add(fifthRecipe);
		Recipe sixthRecipe = new Recipe("Berry Healthy Oat Cookies",
				"Grab a few of these energy-boosting healthy cookies for a quick breakfast, \n"
						+ "or offer as snacks to bridge the hunger gap before dinner. \n"
						+ "Enjoy with yogurt and fruit\n"
						+ "\n"
						+ "Ingredients					Price		Nutritional Content\n"
						+ "2 ripe bananas, mashed			~€1.10		Selenium, Potassium\n"
						+ "150g porridge oats				~€0.90		Fiber, Protein\n"
						+ "2 tbsp ground almonds			~€1.10		Vitamin E, Protein\n"
						+ "1⁄2 tsp cinnamon				~€0.50		Magnesium\n"
						+ "100g raspberries				~€1.50		Vitamin C \n"
						+ "Full details of the recipe will be given on the course\n"
						+ "Book your child's place today!", "15-16" );
		recipeList.add(sixthRecipe);



	}

	public String addRecipe() {

		final Recipe recipe = new Recipe(this.recipeTitle, this.recipeText,	this.ageGroup);
		recipeList.add(recipe);

		recipeTitle = null;
		recipeText = null;
		ageGroup = null;
		return null;
	}

	public ArrayList<Recipe> getRecipeList() {
		return recipeList;
	}


	public ArrayList<Recipe> getRecipeList8_11() {
		ArrayList<Recipe> recipeList8_11 = new ArrayList<>();
		String ageGroup = "8-11";
		for(Recipe recipe: recipeList) {
			if(recipe.getAgeGroup().equals(ageGroup)) {
				recipeList8_11.add(recipe);
			}
		}
		return recipeList8_11;
	}
	public ArrayList<Recipe> getRecipeList12_14() {
		ArrayList<Recipe> recipeList12_14 = new ArrayList<>();
		String ageGroup = "12-14";
		for(Recipe recipe: recipeList) {
			if(recipe.getAgeGroup().equals(ageGroup)) {
				recipeList12_14.add(recipe);
			}
		}
		return recipeList12_14;
	}
	public ArrayList<Recipe> getRecipeList15_16() {
		ArrayList<Recipe> recipeList15_16 = new ArrayList<>();
		String ageGroup = "15-16";
		for(Recipe recipe: recipeList) {
			if(recipe.getAgeGroup().equals(ageGroup)) {
				recipeList15_16.add(recipe);
			}
		}
		return recipeList15_16;
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

	public String editRecipe(Recipe recipe) {
		recipe.setCanEdit(true);
		return null;
	}

	public String deleteRecipe(Recipe recipe) {

		recipeList.remove(recipe);

		return null;
	}

	public String saveAction() {
		for (Recipe recipe : recipeList) {

			recipe.setCanEdit(false);

		}
		return null;
	}


}
