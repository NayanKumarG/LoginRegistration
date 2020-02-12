<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
body {font-family: Arial, Helvetica, sans-serif;}
form {
width: 50%;
border: 3px solid #f1f1f1;}
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
h3{
color:blue;
}
</style>
</head>
<body>
<h3>Login page!!!</h3>
<form action="login" method="post">
<div class="container">
UserName <br><input type="text" placeholder="username" name="name"><br>
Password <br><input type="password" placeholder="password" name="password"><br>
<button type="submit">Login</button>
<a href="Registration.jsp">Registration</a>
</div>
</form>
</body>
</html>