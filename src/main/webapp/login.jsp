<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<center>
	<h1>Railway Crossing</h1>
	<p style=color:grey>User Login</p>
	<form action="login" method="get" style=text-align:left;width:300px>
	Enter Email : <input type="email" name = "mail" style=border-style:solid;border-radius:5px;border-width:0.5px;height:25px;width:300px><br><br>
	Enter Password : <input type = "password" name ="password" style=border-style:solid;border-radius:5px;border-width:0.5px;height:25px;width:300px><br>
	<% String us =(String) session.getAttribute("us"); %>
	<% if(us != null){ %>
		<span style=color:red><%= us %></span>
	<%} %><br>
	<input type="submit" value="LogIn" style=color:white;border:none;border-radius:5px;background:#54C571;width:300px;height:25px>
	</form> 
	<p>Don't have account? <a href="Register.jsp">Create New Account</a></p>
	</center>
</body>
</html>