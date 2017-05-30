package model;

import java.sql.*;
import java.util.LinkedList;

/**
 * A class for the program entry point and some test recipes.
 *
 * @author breukerm
 */
public class CookBook {

	private LinkedList<Recipe> myRecipeList = new LinkedList<>();
	
    /**
     * Creates a Gong Bao Jiding recipe.
     *
     * @return  the new recipe
     */
    private static Recipe createGongBaoJiding() {
        Recipe recipe = new Recipe("Gong Bao Jiding", "Sichuan Dish", 4);

        recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"));
        recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("sugar", 2.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("chicken stock", 3.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("Chiangang vinegar", 4.0, "teaspoon"));
        recipe.addIngredient(new Ingredient("sesame oil", 4.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("dark soy sauce", 2.0, "teaspoon"));
        recipe.addIngredient(new Ingredient("peanut oil", 3.0, "tablespoon"));
        
        

        recipe.addPreparationStep(new Step("Mix together cornstarch and 1 tbsp. of the soy sauce in a medium bowl.","123"));
//TODO
        //        recipe.addPreparationStep("Add chicken, toss well, and set aside to marinate for 30 minutes.");
//        recipe.addPreparationStep("Meanwhile, mix together the remaining 3 tbsp. soy sauce, rice wine, sugar, stock, vinegar, sesame oil, and dark soy sauce.");
//        recipe.addPreparationStep("Set aside.");
//        recipe.addPreparationStep("Heat peanut oil in a wok or large nonstick skillet over high heat until just beginning to smoke.");
//        recipe.addPreparationStep("Add chilis, half the scallions, garlic, ginger, and chicken and stir-fry until chicken is golden, 3-5 minutes.");
//        recipe.addPreparationStep("Add soy sauce mixture and stir-fry until sauce thickens, about 2 minutes.");
//        recipe.addPreparationStep("Stir in peanuts.");
//        recipe.addPreparationStep("Garnish with remaining scallions.");

        recipe.setPreparationTime(30);
        recipe.setCookTime(10);

        return recipe;
    }

    /**
     * Creates a Hong Shao Rou recipe.
     *
     * @return  the recipe
     */
    private static Recipe createHongShaoRou() {
        Recipe recipe = new Recipe("Hong Shao Rou", "Hunan Dish", 4);

     //   recipe.addIngredient(new Ingredient("pork belly", 0.5, "kg", "cut into 2cm pieces"));
        recipe.addIngredient(new Ingredient("cooking oil", 2.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("brown sugar", 1.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("light soy sauce", 1.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("dark soy sauce", 0.5, "tablespoon"));
        recipe.addIngredient(new Ingredient("chicken stock or water", 2.0, "cups"));

//        recipe.addPreparationStep("Bring a pot of water to a boil and blanch the pork for a couple minutes.");
//        recipe.addPreparationStep("Take the pork out of the pot and set aside.");
//        recipe.addPreparationStep("Over low heat, add oil and sugar to your wok.");
//        recipe.addPreparationStep("Melt the sugar slightly and add the pork.");
//        recipe.addPreparationStep("Raise the heat to medium and cook until the pork is lightly browned.");
//        recipe.addPreparationStep("Turn the heat back down to low and add cooking wine, light soy sauce, dark soy sauce, and chicken stock.");
//        recipe.addPreparationStep("Cover and simmer for about 60 minutes to 90 minutes until pork is fork tender.");
//        recipe.addPreparationStep("Every 5-10 minutes, stir to prevent burning and add water if it gets too dry.");
//        recipe.addPreparationStep("Once the pork is fork tender, if there is still a lot of visible liquid, uncover the wok, turn up the heat, and stir continuously the sauce has reduced to a glistening coating.");

        recipe.setPreparationTime(5);
        recipe.setCookTime(100);

        return recipe;
    }

    /**
     * Creates a Suan La Fen recipe.
     *
     * @return  the recipe
     */
    private static Recipe createSuanLaFen() {
        Recipe recipe = new Recipe("Suan La Fen", "Sichuan Dish", 2);

        recipe.addIngredient(new Ingredient("potato noodles", 1.0, "bunch"));
//        recipe.addIngredient(new Ingredient("peanuts", 2.0, "tablespoon", "roasted"));
//        recipe.addIngredient(new Ingredient("spring onion", 1.0, "tablespoon", "chopped"));
//        recipe.addIngredient(new Ingredient("coriander", 1.0, "tablespoon", "chopped"));
//        recipe.addIngredient(new Ingredient("pickled Sichuan vegetable", 2.0, "tablespoon", "chopped"));
//        recipe.addIngredient(new Ingredient("garlic", 3.0, "cloves", "mashed"));
        recipe.addIngredient(new Ingredient("peanut oil", 0.5, "tablespoon"));
        recipe.addIngredient(new Ingredient("Sichuan peppercorn powder", 0.5, "teaspoon"));
        recipe.addIngredient(new Ingredient("Chinese five spicy powder", 0.5, "teaspoon"));
        recipe.addIngredient(new Ingredient("chili powder", 1.0, "teaspoon"));
        recipe.addIngredient(new Ingredient("vinegar", 1.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("light soy sauce", 1.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("salt", 1.0, "teaspoon"));

//        recipe.addPreparationStep("Soak the sweet potato noodles with hot water around 30 minutes.");
//        recipe.addPreparationStep("Transfer out and set aside.");
//        recipe.addPreparationStep("In the serving bowls and mix all the seasonings.");
//        recipe.addPreparationStep("Heat up peanuts oil in pan to stir-fry the mashed garlic until aroma.");
//        recipe.addPreparationStep("Mix the garlic oil with the seasonings.");
//        recipe.addPreparationStep("Add some spring onions and corianders in serving bowls.");
//        recipe.addPreparationStep("Pour in boiling water or stock to tune the seasonings.");
//        recipe.addPreparationStep("Add vinegar and light soy sauce.");
//        recipe.addPreparationStep("Mix well and set aside.");
//        recipe.addPreparationStep("Cook soaked sweet potato noodles around 3~5 minutes until you can break the noodles with your fingers.");
//        recipe.addPreparationStep("Transfer the noodles out to the serving bowls and then add top with pickled vegetables, roasted peanuts and chopped spring onions and coriander. ");

        recipe.setPreparationTime(30);
        recipe.setCookTime(5);

        return recipe;
    }

    /**
     * Program entry point.
     *
     * @param args  command line arguments; not used.
     */
    public static void main(String[] args) {
    	
    	
        CookBook cb = new CookBook();
//TODO
        cb.add(createGongBaoJiding());
        cb.add(createHongShaoRou());
        cb.add(createSuanLaFen());
        
        
        	
        

        cb.getRecipe("Gong Bao Jiding");

    }

	private void add(Recipe recipe) {
		// TODO Auto-generated method stub
		myRecipeList.add(recipe);
		
	}
	
	public void getRecipe(String recipeName) {
		
		System.out.println(Recipe.search(recipeName, myRecipeList));
		
	}
	
}