/*
 * created by:Nayan Kumar
 * purpose:Servlet to get the registration request by client
 */
package com.bridgelabz.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.RegistrationModel;
import com.bridgelabz.service.RegistrationInf;
import com.bridgelabz.serviceimpl.RegistrationImpl;

/*
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static RegistrationModel rmodel = new RegistrationModel();
	private static RegistrationInf rinf = new RegistrationImpl();

	/*
	 * doPost method which take the request from client
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String city = request.getParameter("city");
		int age = Integer.parseInt(request.getParameter("age"));
		String phno = request.getParameter("phno");

		rmodel.setName(name);
		rmodel.setPassword(password);
		rmodel.setMail(mail);
		rmodel.setCity(city);
		rmodel.setAge(age);
		rmodel.setPhno(phno);
		rinf.saveData(rmodel);
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);





	}

}
