/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package web;

import adt.bst.BinarySearchTree;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
public class DictSessionInit extends HttpServlet {

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Completely refresh the session
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		session = request.getSession();
		
		// Create a new BST
		BinarySearchTree<FoodItem> bst = new BinarySearchTree<FoodItem>();
		session.setAttribute("dictionary", bst);
		request.setAttribute("action", "Add");
		
		RequestDispatcher view = request.getRequestDispatcher("item.jsp");
		view.forward(request, response);
	}
}
