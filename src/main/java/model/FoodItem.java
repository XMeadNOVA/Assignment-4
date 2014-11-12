/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package model;

import adt.linked_list.LinkedList;
import java.io.Serializable;

/**
 * A food item has a name and a list of ingredients.
 * It is comparable with other FoodItems by name.
 * @author Xan Mead
 */
public class FoodItem implements Comparable<FoodItem>, Serializable {
	private String name;
	private LinkedList<String> ingredients;
	
	/**
	 * Creates a new FoodItem with no ingredients.
	 * @param name Name of the FoodItem
	 */
	public FoodItem(String name) {
		this.name = name;
		ingredients = null;
	}
	/** @return name of the food*/
	public String getName() {
		return name;
	}
	
	/** @return LinkedList of the ingredients in this food*/
	public LinkedList<String> getIngredients() {
		return ingredients;
	}
	
	/** @param ing name of the ingredient to be added to the FoodItem*/
	public void addIngredient(String ing) {
		ingredients.add(ing);
	}
	
	/** @param ing name of the ingredient to be removed from the FoodItem*/
	public void removeIngredient(String ing) {
		ingredients.remove(ing);
	}
	
	@Override
	public int compareTo(FoodItem t) {
		return this.name.compareToIgnoreCase(((FoodItem)t).getName());
	}
}
