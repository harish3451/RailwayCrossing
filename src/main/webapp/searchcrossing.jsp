<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int n=0; %>
<% if( session.getAttribute("user") != null) {n=1;%>
<jsp:include page="userHome.jsp"></jsp:include>
<%} %>

<% if (session.getAttribute("admin") != null){n=1; %>
<jsp:include page="AdminHome.jsp"></jsp:include>
<%} %>

<% if (n==0){ %>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>
<form action = "search" >
	<input type="text" name="find" >
	<input type="submit" value="Search">
</form>
</body>
</html>