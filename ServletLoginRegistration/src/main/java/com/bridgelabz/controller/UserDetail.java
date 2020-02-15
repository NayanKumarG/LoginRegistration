/*
 * created by:Nayan Kumar
 * 
 * purpose:controller to display user detail
 * 
 */

package com.bridgelabz.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.Users;
import com.bridgelabz.service.UserInf;
import com.bridgelabz.serviceimpl.UsersDao;

@WebServlet("/userdetail")
public class UserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserInf uinf = new UsersDao();  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		PrintWriter out = response.getWriter();
		int pageNo =Integer.parseInt(request.getParameter("page"));
		
		int total = 4;
		
		if (pageNo>=2)
		{
			pageNo = (pageNo-1)*total+1;
		}

		List<Users> users = uinf.getUsers(pageNo , total);
		out.print("<table border='1' cellpadding='4' width='60%>'");
		out.print("<tr><th>Name</th><th>City</th><th>mailid</th><th>Age</th><th>phno</th></tr>");
		for(Users user : users )
		{
			out.print("<tr><td>"+user.getName()+"</td><td>"+user.getCity()+"</td><td>"+user.getMailid()+"</td><td>"+user.getAge()+"</td><td>"+user.getPhno()+"</td></tr>");
		}
		out.print("</table></br></br>");
		out.print("<a href='userdetail?page=1'>1</a>");
		out.print("&nbsp;&nbsp;<a href='userdetail?page=2'>2</a>");
		out.print("&nbsp;&nbsp;<a href='userdetail?page=3'>3</a>");
		out.print("&nbsp;&nbsp;&nbsp;&nbsp;<a href='welcome.jsp'><button type='button'>Back</button></a>");
		out.close();

	}


}
