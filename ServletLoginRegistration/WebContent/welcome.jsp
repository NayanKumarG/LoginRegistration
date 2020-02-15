<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="javax.servlet.http.Cookie , java.io.PrintWriter , javax.servlet.ServletContext"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Scriplet to check session and to clear cache --%>
	<%
	PrintWriter write = response.getWriter();
	response.setHeader("Cache-Control", "no-cache,no-store,no-validate");
	
		if (session.getAttribute("username") == null) {
			response.sendRedirect("Login.jsp");
		}
		
		Cookie ck[] = request.getCookies();
		String name="";
		for(Cookie c : ck)
		{
			if(c.getName().equals("name"))
			{
			
			name = c.getValue();
			}
		}
		write.println("<h4>Welcome "+name+"</h4>");
	%>
	

	<form action="logout" method="post">
		<input type="submit" value="logout">
		</form>
		<a href="userdetail?page=1">UserDetail</a>
</body>
</html>