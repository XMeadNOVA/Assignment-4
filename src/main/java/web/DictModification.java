/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package web;

import adt.bst.BinarySearchTree;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FoodItem;

/**
 * This servlet handles requests to add, remove or edit entries in the Food Dictionary.
 * @author Xan Mead
 */
@WebServlet(name = "DictModifier", urlPatterns = {"/Food.do"})
public class DictModification extends HttpServlet {

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		// ADD a food item
		if (action.equals("add")) {
			String foodName = request.getParameter("foodName");
			if (!foodName.equals("")) {
				// Create FoodItem
				FoodItem item = new FoodItem(foodName);
				String[] ingredients = request.getParameterValues("ingredients");
				for (String i : ingredients) {
					item.addIngredient(i);
				}
				// Get the session dictionary
				HttpSession session = request.getSession();
				BinarySearchTree<FoodItem> dict = (BinarySearchTree<FoodItem>) session.getAttribute("dictionary");
				dict.insert(item);
			}
		}
	}

}
