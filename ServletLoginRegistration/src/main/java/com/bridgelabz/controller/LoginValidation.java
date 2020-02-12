/*
 * created by:Nayan Kumar
 * purpose:servlet filter to validate login detail
 */
package com.bridgelabz.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * Servlet Filter implementation class LoginValidation
 */
//@WebFilter("/login")
public class LoginValidation implements Filter {

	/*
	 * passing request after validation using chain
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest)request;
		String uname = req.getParameter("name");
		String password = req.getParameter("password");
		if(uname.equals("") || password.equals(""))

			out.println("Fill all the fields");

		else

			chain.doFilter(request, response);

	}



}
