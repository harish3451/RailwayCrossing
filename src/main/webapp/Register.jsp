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
	<h1>RailWay Crossing</h1>
	<p style=color:grey>User Register</p>
	<form action="register" method=GET style=text-align:left;width:300px>
		Enter Name : <input type= "text" name="name" style=border-style:solid;border-radius:5px;border-width:0.5px;height:25px;width:300px><br><br>
		Enter Email : <input type="email" name="mail" style=border-style:solid;border-radius:5px;border-width:0.5px;height:25px;width:300px><br><br>
		Enter Password : <input type="password" name = "password" style=border-style:solid;border-radius:5px;border-width:0.5px;height:25px;width:300px><br><br>
		<input type="submit" Value="Register" style=color:white;border:none;border-radius:5px;background:#54C571;width:300px;height:25px>
	</form>
	<br>
	Already have account? <a href="login.jsp">Sign In Instead</a>
	</center>
</body>
</html>