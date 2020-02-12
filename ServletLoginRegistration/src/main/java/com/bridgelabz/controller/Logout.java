/*
 * created by:Nayan Kumar
 * purpose:Removing session
 */

package com.bridgelabz.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * when logout the session will be removed
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("Login.jsp");

	}

}
