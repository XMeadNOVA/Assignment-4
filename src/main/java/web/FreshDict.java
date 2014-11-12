/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet destroys any existing session and replaces it with a new one.
 * @author Xan Mead
 */
public class FreshDict extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Get the session if it exists
		HttpSession session = request.getSession(false);
		
		// Try to invalidate
		if (session != null) {
			session.invalidate();
		}
		
		// Start a new session
		request.getSession();
		
		// Send to add page
		request.setAttribute("action", "Add");
		RequestDispatcher view = request.getRequestDispatcher("item.jsp");
		view.forward(request, response);
	}
}
