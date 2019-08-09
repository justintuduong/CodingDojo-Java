<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkerboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./style.css">

</head>
<body>

<!-- ----------------------------------------------------------------------
Parameter requests
------------------------------------------------------------------------ -->

<% 
	String row = request.getParameter("row");
	if (row == null){
		row = "5";
	}
	String col = request.getParameter("col"); 
	if (col == null){
		col = "10";
	}
%>
	
<!-- ----------------------------------------------------------------------
CheckerBoard
------------------------------------------------------------------------ -->

<h1> Checkerboard: <%= row %>w X <%= col %>h </h1>

<table>
	<%
	for (int i = 1; i<= Integer.parseInt(row); i++) { 					/* loop will create rows */
	%>
	
	<tr>
	
	<%
	for (int j = 1; j<= Integer.parseInt(col); j++) {					/* nested loop will create col */
	%>
	
	<td class="border border-dark pt-5 pl-5 pr-5 pb-5 color<%= (i+j)%2+1 %>"></td>
	
	<% } %>	
	
	</tr>	
															
	<% } %>
</table>

</body>
</html>