<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style=float:left;width:100%>User Home page</h1>
<%if(session.getAttribute("user") == null){%>
		<jsp:forward page="login.jsp"></jsp:forward>
<%} %>


<form action="allcrossing" Style=float:left;padding:10px>
	<input type="submit" value="All Crossing" style=border:none;border-radius:5px;height:25px>	
</form>
<form action="favoriteCrossing" Style=float:left;padding:10px>
	<input type="submit" value="favoriteCrossing" style=border:none;border-radius:5px;height:25px>	
</form>
<form action="searchcrossing.jsp" Style=float:left;padding:10px>
	<input type="submit" value="searchcrossing" style=border:none;border-radius:5px;height:25px>	
</form>
<form action="UserLogout.jsp" style=float:right;position:absolute;top:50px;right:50px >
	<input type="submit" value ="Log Out" style=border:none;border-radius:5px;height:25px> 
</form>
<div style=clear:both></div>
</body>
</html>