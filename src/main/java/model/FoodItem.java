/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package model;

import adt.linked_list.LinkedList;

public class FoodItem implements Comparable {
	private String name;
	private LinkedList<String> ingredients;
	
	public FoodItem(String name) {
		this.name = name;
		ingredients = null;
	}
	
	public String getName() {
		return name;
	}
	
	public LinkedList<String> getIngredients() {
		return ingredients;
	}
	
	public void addIngredient(String ing) {
		ingredients.add(ing);
	}
	
	public void removeIngredient(String ing) {
		ingredients.remove(ing);
	}
	
	@Override
	public int compareTo(Object t) {
		return this.name.compareToIgnoreCase(((FoodItem)t).getName());
	}
}
