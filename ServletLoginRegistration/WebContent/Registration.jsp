<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	width: 50%;
	border: 3px solid #f1f1f1;
}

.container {
	padding: 16px;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}
</style>
</head>
<body>
<h3>Register here!!!</h3>
	<form action="register" method="post">
		<div class="container">
			UserName <br>
			<input type="text" placeholder="username" name="name" required><br>
			Password <br>
			<input type="password" placeholder="password" name="password"
				required><br> Gmail <br>
			<input type="text" placeholder="gmail" name="mail" required><br>
			City <br>
			<input type="text" placeholder="city" name="city" required><br>
			Age <br>
			<input type="text" placeholder="age" name="age" required><br>
			PhoneNo <br>
			<input type="text" placeholder="phno" name="phno" required><br>
			<button type="submit">Submit</button>
			<button type="button" onclick="Login.jsp">Back</button>
		</div>
	</form>
</body>
</html>