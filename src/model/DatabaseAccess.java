package model;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



/**
 * connect with the database and perform queries
 * include all operations (create, read, update and 
 * delete) of recipes, steps and ingredients
 * 
 * @author Gang Shao
 * @author Qiwen Gu
 * @author Wenbin Shi
 * @author Sijie Chen
 * @author Yuefeng Liu
 * 
 * @version 1.8
 *
 */
public class DatabaseAccess {
	
	Connection con;
	
	/**
	 * build the connection
	 * @throws SQLException
	 */
	public void connectdb() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookbook", "root", "Nocturnes");

		if (!con.isClosed()) {

			System.out.println("Connect Successfully!");

		}

	}
	
	public void retrieveRecipe() throws SQLException {


		Statement stmt = con.createStatement();

		ResultSet rset = stmt.executeQuery("SELECT * FROM cookbook.recipe;");

		System.out.println("Recipe Table");

		System.out.println("=======================================================");

		while (rset.next()) {

			int recipeId = rset.getInt("recipe_id");

			int serveNum = rset.getInt("servings");

			int preparationTime = rset.getInt("preparationTime");

			int cookingTime = rset.getInt("cookingTime");

			int isFavourite = rset.getInt("isFavourite");

			String name = rset.getString("name");

			String description = rset.getString("description");

			String briefDescription = rset.getString("briefDescription");

			String thumbnail = rset.getString("thumbnail");

			Timestamp createdAt = rset.getTimestamp("createdAt");

			DateFormat createFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Timestamp updatedAt = rset.getTimestamp("updatedAt");

			DateFormat updateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Timestamp deletedAt = rset.getTimestamp("deletedAt");

			DateFormat deleteFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			System.out.println("Name: " + name + '\n' + "Recipe Id: " + recipeId + '\n' + "Preparation Time: "
					+ preparationTime + '\n' + "Cooking Time: " + cookingTime + '\n' + "Serve Number:  " + serveNum
					+ '\n' + "Is Favorite: " + isFavourite + '\n' + "Created At:  " + createFormat.format(createdAt)
					+ '\n' + "Updated At:  " + updateFormat.format(updatedAt) + '\n' + "deleted At:  "
					+ deleteFormat.format(deletedAt) + '\n' + "Description:   " + description + '\n'
					+ "Breif Description:   " + briefDescription + '\n' + "Thumbnail: " + thumbnail);

			System.out.println("-------------------------------------------------------");
		}

	}
	
	public void insertRecipe() throws SQLException {

		Statement stmt = con.createStatement();

		int rset = stmt.executeUpdate(
				"INSERT INTO `cookbook`.`recipe` (`name`, `servings`, `preparationTime`, `cookingTime`, `description`, `isFavourite`, `briefDescription`) VALUES ('DD','3','10','10','AAA','1','EEE');");


	}
	
	public void deleteRecipe() throws SQLException {

		Statement stmt = con.createStatement();

		int rset = stmt.executeUpdate("DELETE FROM `cookbook`.`recipe` WHERE `recipe_id`='5';");
		
	} 
	
	public void updateRecipe() throws SQLException {

		Statement stmt = con.createStatement();

		int rset = stmt.executeUpdate("UPDATE `cookbook`.`recipe` SET `name`='updated: dd'  WHERE `recipe_id`='6' ;");

	}
	
	/*
	 * A method to retreave all records from step table.
	 * 
	 * @ param null
	 * 
	 * @ return null
	 * 
	 * **/
	
	public void retrieveStep() throws SQLException {

		Statement stmt = con.createStatement();

		ResultSet rset = stmt.executeQuery("SELECT * FROM cookbook.preparation_step;");

		System.out.println("preparation_step Table(id, step, description, picUri): \n ");

		while (rset.next()) {

			int  stepId = rset.getInt("recipe_id");
			
			int  stepOrder = rset.getInt("stepOrder");
			
			String description = rset.getString("description");

			String picUri = rset.getString("picUri");

			System.out.println( stepId + "  " +  stepOrder + "  " + description + "  " + picUri + "\n");

		}

	}
	
	/*
	 * A method to insert a record to step table.
	 * Which is "`recipe_id`, `stepOrder`, `description`, `picUri`) VALUES ('4', '5', 'The fifth step of Mapo doufu.', 'Mapo doufu_5.jpg'"
	 * Whose id is always 4.
	 * 
	 * 
	 * @ param null
	 * 
	 * @ return null
	 * 
	 * **/
	
	public void insertStep() throws SQLException {

		Statement stmt = con.createStatement();

		int rset = stmt
				.executeUpdate("INSERT INTO `cookbook`.`preparation_step` (`recipe_id`, `stepOrder`, `description`, `picUri`) VALUES ('4', '5', 'The fifth step of Mapo doufu.', 'Mapo doufu_5.jpg');");
		
	} 
	
	/*
	 * A method to delete a record whose `recipe_id`='4' and `stepOrder`='5'.
	 * 
	 * 
	 * @ param null
	 * 
	 * @ return null
	 * 
	 * **/
	
	public void deleteStep() throws SQLException {

		Statement stmt = con.createStatement();

		int rset = stmt.executeUpdate("DELETE FROM `cookbook`.`preparation_step` WHERE `recipe_id`='4' and `stepOrder`='5';");
		
	} 
	
	/*
	 * A method to update a step recond.
	 * UPDATE one record  WHERE `recipe_id`='4' and `stepOrder`='5'. SET `description`='updated: The fifth step of Mapo doufu.' ; 
	 * 
	 * 
	 * @ param null
	 * 
	 * @ return null
	 * 
	 * **/
	
	public void updateStep() throws SQLException {

		Statement stmt = con.createStatement();

		int rset = stmt.executeUpdate("UPDATE `cookbook`.`preparation_step` SET `description`='updated: The fifth step of Mapo doufu.'  WHERE `recipe_id`='4' and `stepOrder`='5';");

	}
	
	/**
	 * retrieve all ingredients from given recipe from database
	 * 
	 * @param recipe
	 *            given recipe
	 * @author Gang Shao
	 */
	public void retrieveIngredient(Recipe recipe) throws SQLException {
		int index = 1;

		String query = "SELECT * FROM ingredient" + " WHERE recipe_id ="
				+ " (SELECT recipe_id FROM recipe WHERE name = ? and createdAt = ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(index++, recipe.getName());
		preparedStmt.setDate(index++, recipe.getCreatedAt());
		preparedStmt.execute();

		// while (rset.next()) {
		// int recipe_id = rset.getInt("recipe_id");
		// String ingredientName = rset.getString("name");
		// double quantity = rset.getDouble("quantity");
		// String unit = rset.getString("unit");
		//
		// System.out.println(recipe_id + " " + ingredientName + " " + quantity
		// + " " + unit + "\n");
		// }
	}
	
	
	/**
	 * insert new ingredient to given recipe in database
	 * 
	 * @param ingredient
	 *            new ingredient
	 * @param recipe
	 *            given recipe where new ingredient will be inserted to
	 * @author Gang Shao
	 */
	public void insertIngredient(Ingredient ingredient, Recipe recipe) throws SQLException {
		int index = 1;
		String query = "INSERT INTO ingredient (recipe_id, name, quantity, unit)"
				+ " values ((SELECT recipe_id FROM recipe WHERE name = ? and createdAt = ?), ?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);

		preparedStmt.setString(index++, recipe.getName());
		preparedStmt.setDate(index++, recipe.getCreatedAt());
		preparedStmt.setString(index++, ingredient.getName());
		preparedStmt.setDouble(index++, ingredient.getAmount());
		preparedStmt.setString(index++, ingredient.getUnit());

		preparedStmt.execute();
	}
	
	
	/**
	 * delete ingredient from given recipe in database
	 * 
	 * @param ingredient
	 *            ingredient to be deleted
	 * @param recipe
	 *            recipe where the ingredient will be deleted
	 * @author Gang Shao
	 */
	public void deleteIngredient(Ingredient ingredient, Recipe recipe) throws SQLException {
		int index = 1;

		String query = "DELETE * FROM ingredient" + " WHERE recipe_id ="
				+ " (SELECT recipe_id FROM recipe WHERE name = ? and createdAt = ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(index++, recipe.getName());
		preparedStmt.setDate(index++, recipe.getCreatedAt());
		preparedStmt.execute();
	}
	
	/**
	 * update ingredient of given recipe in database
	 * 
	 * @param oldIngredient
	 *            the old ingredient need to be updated
	 * @param newIngredient
	 *            new ingredient
	 * @param recipe
	 *            recipe where the ingredient will be updated
	 * @author Gang Shao
	 */
	public void updateIngredient(Ingredient oldIngredient, Ingredient newIngredient, Recipe recipe)
			throws SQLException {
		int index = 1;

		String query = "UPDATE ingredient" + "SET name = ?, quantity = ?, unit = ?" + " WHERE recipe_id ="
				+ " (SELECT recipe_id FROM recipe WHERE name = ? and createdAt = ?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(index++, newIngredient.getName());
		preparedStmt.setDouble(index++, newIngredient.getAmount());
		preparedStmt.setString(index++, newIngredient.getUnit());
		preparedStmt.setString(index++, recipe.getName());
		preparedStmt.setDate(index++, recipe.getCreatedAt());
		preparedStmt.execute();
	}
	
	
	public static void main(String[] args) throws SQLException {

		DatabaseAccess databaseAccess = new DatabaseAccess();

		databaseAccess.connectdb();
		
		//Ingredient table CRUD
//		
//		databaseAccess.retrieveIngredient();
//		
//		databaseAccess.insertIngredient();
//		
//		databaseAccess.retrieveIngredient();
//		
//		databaseAccess.updateIngredient();
//		
//		databaseAccess.retrieveIngredient();
//		
//		databaseAccess.deleteIngredient();
//		
//		databaseAccess.retrieveIngredient();
		
		//recipe table CRUD
		
		databaseAccess.retrieveRecipe();
		
		databaseAccess.insertRecipe();

		databaseAccess.retrieveRecipe();
		
		databaseAccess.updateRecipe();
		
		databaseAccess.retrieveRecipe();
	
		databaseAccess.deleteRecipe();
		
		databaseAccess.retrieveRecipe();
		
		//Step table CRUD

		databaseAccess.retrieveStep();
		
		databaseAccess.insertStep();
		
		databaseAccess.retrieveStep();
	
		databaseAccess.updateStep();
		
		databaseAccess.retrieveStep();
		
		databaseAccess.deleteStep();
		
		databaseAccess.retrieveStep();
		
	}
	
	

}
