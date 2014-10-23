/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amm28964
 */
public class FoodItem implements Comparable {
	private String name;
	private LinkedListNode<String> list;
	
	public FoodItem(String name) {
		this.name = name;
		list = null;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Object t) {
		return this.name.compareToIgnoreCase(((FoodItem)t).getName());
	}
}
