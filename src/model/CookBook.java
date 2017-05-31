package model;

import java.sql.*;
import java.util.LinkedList;

/**
 * A class for the program entry point and some test recipes.
 *
 * @author breukerm
 */
public class CookBook {
	private DatabaseAccess dataBaseAccess;
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
        
        

        recipe.addPreparationStep(new Step("1. step for GongBaoJiding","picUri"));
        recipe.addPreparationStep(new Step("2. step for GongBaoJiding.","picUri"));
        recipe.addPreparationStep(new Step("3. step for GongBaoJiding.","picUri"));
        recipe.addPreparationStep(new Step("4. step for GongBaoJiding.","picUri"));
        recipe.addPreparationStep(new Step("5. step for GongBaoJiding.","picUri"));
     

        recipe.setPreparationTime(30);
        recipe.setCookTime(10);

        return recipe;
    }

    /**
     * Creates a Hong Shao Rou recipe.
     *
     * @return  the recipe
     */
    static Recipe createHongShaoRou() {
        Recipe recipe = new Recipe("Hong Shao Rou", "Hunan Dish", 4);

     //   recipe.addIngredient(new Ingredient("pork belly", 0.5, "kg", "cut into 2cm pieces"));
        recipe.addIngredient(new Ingredient("cooking oil", 2.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("brown sugar", 1.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("light soy sauce", 1.0, "tablespoon"));
        recipe.addIngredient(new Ingredient("dark soy sauce", 0.5, "tablespoon"));
        recipe.addIngredient(new Ingredient("chicken stock or water", 2.0, "cups"));
        
        recipe.addFavourite();
        
        recipe.setBriefDescription("Brief Description of Hong Shao Rou.");
        
        recipe.setDescription("Description of Hong Shao Rou.");

        recipe.addPreparationStep(new Step("1. step for Hong Shao Rou","picUri"));
        recipe.addPreparationStep(new Step("2. step for Hong Shao Rou.","picUri"));
        recipe.addPreparationStep(new Step("3. step for Hong Shao Rou.","picUri"));
        recipe.addPreparationStep(new Step("4. step for Hong Shao Rou.","picUri"));
        recipe.addPreparationStep(new Step("5. step for Hong Shao Rou.","picUri"));

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

        recipe.addPreparationStep(new Step("1. step for SuanLaFen","picUri"));
        recipe.addPreparationStep(new Step("2. step for SuanLaFen.","picUri"));
        recipe.addPreparationStep(new Step("3. step for SuanLaFen.","picUri"));
        recipe.addPreparationStep(new Step("4. step for SuanLaFen.","picUri"));
        recipe.addPreparationStep(new Step("5. step for SuanLaFen.","picUri"));

        recipe.setPreparationTime(30);
        recipe.setCookTime(5);

        return recipe;
    }

    /**
     * Program entry point.
     *
     * @param args  command line arguments; not used.
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
    	
    
        CookBook cb = new CookBook();
        
       cb.dataBaseAccess = new DatabaseAccess();
       
       cb.dataBaseAccess.connectdb();

      cb.dataBaseAccess.insertRecipe(createHongShaoRou());
      
      cb.dataBaseAccess.insertRecipe(createSuanLaFen());
      
      cb.dataBaseAccess.insertRecipe(createGongBaoJiding());

      cb.dataBaseAccess.retrieveRecipe();

    }

	private void add(Recipe recipe) {
		// TODO Auto-generated method stub
		myRecipeList.add(recipe);
		
	}
	
	public void getRecipe(String recipeName) {
		
		System.out.println(Recipe.search(recipeName, myRecipeList));
		
	}
	
}