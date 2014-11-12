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
 *
 * @author Xan Mead
 */
public class FreshDict extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		request.getSession();
		
		request.setAttribute("action", "Add");
		RequestDispatcher view = request.getRequestDispatcher("item.jsp");
	}
	
}
