/*
 * created by:Nayan Kumar
 * 
 * purpose:controller for login
 * 
 */

package com.bridgelabz.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bridgelabz.model.LoginModel;
import com.bridgelabz.service.LoginInf;
import com.bridgelabz.serviceimpl.LoginImpl;

/*
 * Servlet implementation class Login
 */
//@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static LoginModel lmodel = new LoginModel();
	static LoginInf linf = new LoginImpl();
	private static final Logger log = LogManager.getLogger(Login.class);
	
	/*
	 * overriding doPost method
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		log.info("Login success");
		HttpSession session = request.getSession();
		session.setAttribute("username", name);
		Cookie ck = new Cookie("name" , name);
		ck.setHttpOnly(true);
		response.addCookie(ck);
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}
}
