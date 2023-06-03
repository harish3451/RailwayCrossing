<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<style type="text/css">
	
</style>
</head>
<body>
<h1 style=float:left;width:100%>Admin Home page</h1>
<%if(session.getAttribute("admin") == null){%>
		<jsp:forward page="adminlogin.jsp"></jsp:forward>
<%} %>


<form action="home" Style=float:left;padding:10px>
	<input type="submit" value="Home" style=border:none;border-radius:5px;height:25px>	
</form>
<form action="AddCrossing.jsp" Style=float:left;padding:10px>
	<input type="submit" value="Add Railway Crossing" style=border:none;border-radius:5px;height:25px>	
</form>
<form action="searchcrossing.jsp" Style=float:left;padding:10px>
	<input type="submit" value="searchcrossing" style=border:none;border-radius:5px;height:25px>	
</form>
<form action="AdminLogout.jsp" style=float:right;position:absolute;top:50px;right:50px >
	<input type="submit" value ="LogOut" style=border:none;border-radius:5px;height:25px> 
</form>
<div style=clear:both></div>

</body>
</html>