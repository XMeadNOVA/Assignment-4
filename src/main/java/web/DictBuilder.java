/*
 * Xan Mead - Fall 2014
 * amm28964@email.vccs.edu
 */
package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet recieves serialized Food Dictionaries and deserializes them
 * into a new session. Any previous session is invalidated.
 * @author Xan Mead
 */
@WebServlet(name = "DictBuilder", urlPatterns = {"/RebuildDict.do"})
public class DictBuilder extends HttpServlet {

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
		
	}
}
