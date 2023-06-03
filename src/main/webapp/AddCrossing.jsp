<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.f1{
		style=text-align:left;
		width:300px;
		left:100px
	}
	.i1{
		margin-bottom:20px;
		border-style:solid;
		border-radius:5px;
		border-width:0.5px;
		height:25px;
		width:300px
	}
</style>
</head>
<body>
	<jsp:include page="AdminHome.jsp" ></jsp:include>
	<form action="AddCrossing" method="get" class="f1" Style=position:absolute;top:150px>
	<h1>Adding New Crossing</h1>
 	<center><p style=color:grey>Add Crossing</p></center>
		Enter Crossing Name:
		<input type="text" name="name" class="i1">
		
		Enter Crossing Status:<br>
		<!--<input type="text" name="status" class="i1">-->
		<input type="radio" name="status" value="Open">OPEN<BR>
		<input type="radio" name="status" value="Open">CLOSE<BR>
		Enter Person-in-charge:
		<input type="text" name="person" class="i1">
		
		Enter Train Schedule:
		<input type = "text" name="schedule" class="i1">
		
		Enter Landmark:
		<input type = "text" name="landmark" class="i1">
		
		Enter Address:
		<input type="text" name="address" class="i1">
		
		<input type="submit" name="Add Crossing" style=color:white;border:none;border-radius:5px;background:#54C571;width:300px;height:25px>
 	</form>
</body>
</html>