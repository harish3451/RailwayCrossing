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
	<h1>Admin login</h1>
 	<p style=color:grey>Admin Login</p>
	<form action="adminlogin" method="get" style=text-align:left;width:300px>
	enter mail <input type="email" name = "mail" style=border-style:solid;border-radius:5px;border-width:0.5px;height:25px;width:300px><br><br>
	enter password <input type = "password" name ="password" style=border-style:solid;border-radius:5px;border-width:0.5px;height:25px;width:300px><br><br>
	<% String us =(String) session.getAttribute("us"); %>
	<% if(us != null){ %>
		<span style=color:red><%= us %></span>
	<%} %><br>
	<input type="submit" Value="Login" style=color:white;border:none;border-radius:5px;background:#54C571;width:300px;height:25px>
	</form> 
	</center>
</body>
</html>