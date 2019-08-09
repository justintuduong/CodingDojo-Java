<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo JSP</title>
</head>
<body>

<%!
public int add(int a, int b) {
	return a + b;
}
%>

<%
int i = 2;
int j = 4;
%>

<h3> <%= add(i, j) %></h3>

<% for(int idx = 0; idx <= 5; idx++) { %>
	<h1><%= idx %></h1>
<% } %>

<p> The time is: <%= new Date() %>


</body>
</html>