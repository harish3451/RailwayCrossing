<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="com.user.CrossingDetails" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("admin") == null) {%>
	<jsp:forward page="adminlogin.jsp"></jsp:forward>
	<%} %>
	
	<center>
		<h2>Railway Crossing</h2>
		<p style=color:grey>Update Raiways Crossing details</p>
	</center>
</body>
</html>