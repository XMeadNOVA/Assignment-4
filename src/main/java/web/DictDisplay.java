/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */

package web;

import adt.bst.BinarySearchTree;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FoodItem;

/**
 *
 * @author Xan Mead
 */
public class DictDisplay extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String query = request.getParameter("query");
		BinarySearchTree<FoodItem> bst = (BinarySearchTree<FoodItem>) session.getAttribute("dictionary");
		FoodItem item = null;
		if (query != null) {
			item = bst.get(new FoodItem(query));
		}
		if (item == null) {
			// "Item not found"
			request.setAttribute("result", new Boolean(false));
		}
		else {
			// Edit or remove
			request.setAttribute("result", new Boolean(true));
			request.setAttribute("item", item);
		}
		
		// Forward to results page
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}
	
}
