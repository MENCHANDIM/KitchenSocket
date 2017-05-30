/**
 * A Recipe Class
 * 
 * @author Qiwen Gu, Gang Shao
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.LinkedList;

public class Recipe implements Serializable {

	private String name;
	private String briefDescription;
	private String thumbnail;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private ArrayList<Step> steps = new ArrayList<Step>();
	private int preparationTime;
	private int cookTime;
	private Date createdAt;
	private Date deletedAt;
	private Date updatedAt;
	private boolean isFavourite;
	private int servingNum;
	private String tag;

	public Recipe() {
		super();
		this.name = "";
		this.briefDescription = "";
		this.thumbnail = "";
		this.ingredients = null;
		this.steps = null;
		this.preparationTime = 0;
		this.cookTime = 0;
		this.createdAt = null;
		this.deletedAt = null;
		this.updatedAt = null;
		this.isFavourite = false;
		this.servingNum = 0;
		this.tag = "";
	}

	public Recipe(String name, String tag, int servingNum) {
		super();
		this.name = name;
		this.tag = tag;
		this.servingNum = servingNum;
	}

	public Recipe(String name, String tag, int servingNum, String briefDescription, String thumbnail,
			ArrayList<Ingredient> ingredients, ArrayList<Step> steps, int preparationTime, int cookTime,
			Date createdAt) {
		super();
		this.name = name;
		this.tag = tag;
		this.servingNum = servingNum;
		this.briefDescription = briefDescription;
		this.thumbnail = thumbnail;
		this.ingredients = ingredients;
		this.steps = steps;
		this.preparationTime = preparationTime;
		this.cookTime = cookTime;
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isFavourite() {
		return isFavourite;
	}

	public void addFavourite() {
		this.isFavourite = true;
	}

	public void removeFavourite() {
		this.isFavourite = false;
	}

	public int getServingNum() {
		return servingNum;
	}

	public void setServingNum(int servingNum) {
		this.servingNum = servingNum;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * Search for Recipes
	 * 
	 * @param name
	 *            Recipe name
	 * @return target recipes
	 */
	public static String search(String name, LinkedList<Recipe> myRecipeList) {

		String results = "";

		String[] search = name.toLowerCase().split(" ");
		for (int recipeId = 0; recipeId < myRecipeList.size(); recipeId++) {// ArrayList
			// Recipes
			String recipeName = myRecipeList.get(recipeId).getName().toLowerCase();
			String[] recipe = recipeName.split(" ");
			for (int recipeNum = 0; recipeNum < recipe.length; recipeNum++) {

				for (int searchNum = 0; searchNum < search.length; searchNum++) {

					if (recipe[recipeNum].equals(search[searchNum])) {
						results = results + myRecipeList.get(recipeId).toString();
						break;
					}
				}
				break;
			}

		}
		return results;
	}

	@Override
	public String toString() {
		return "Recipe" + '\n' + "====================" + '\n' + "Name: " + name + '\n' + "Tag: " + tag + '\n'
				+ "ServingNum: " + servingNum + '\n' + "BriefDescription: " + briefDescription + '\n' + "Thumbnail: "
				+ thumbnail + '\n' + "PreparationTime: " + preparationTime + '\n' + "CookTime: " + cookTime + '\n'
				+ "CreatedAt: " + createdAt + '\n' + "DeletedAt:" + '\n' + deletedAt + "UpdatedAt: " + updatedAt + '\n'
				+ "IsFavourite=" + isFavourite + '\n' + "====================" + '\n' + "Ingredients:" + '\n'
				+ "====================" + '\n' + ingredients + '\n' + "====================" + '\n'
				+ "Steps:" + '\n' + "====================" + '\n' + showSteps(steps) + '\n';
	}

	private String showSteps(ArrayList<Step> steps) {
		// TODO Auto-generated method stub
		String stepsS = "";
		for (Step item : steps) {
			stepsS += item.getStepDescription() + "\n";
		}
		return stepsS;
	}

	public void addIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		ingredients.add(ingredient);
	}

	public void addPreparationStep(Step step) {
		// TODO Auto-generated method stub
		steps.add(step);

	}

}
