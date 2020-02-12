<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- Scriplet to check session and to clear cache --%>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,no-validate");
	
		if (session.getAttribute("username") == null) {
			response.sendRedirect("Login.jsp");
		}
	%>
	welcome ${username}

	<form action="logout" method="post">
		<input type="submit" value="logout">
	</form>
</body>
</html>