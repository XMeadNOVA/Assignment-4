/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package web;

import adt.bst.BinarySearchTree;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import model.FoodItem;

/**
 *
 * @author Xan Mead
 */
public class DictSessionInit implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		BinarySearchTree<FoodItem> bst = new BinarySearchTree<FoodItem>();
		session.setAttribute("dictionary", bst);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		// Nothing to do here...
	}
	
}
