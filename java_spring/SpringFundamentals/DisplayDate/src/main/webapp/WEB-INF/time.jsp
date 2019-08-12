<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time</title>

</head>
<body>
	<div class="container">
		<h1>
			<fmt:formatDate type="time" timeStyle="short" value="${time}"/>
		</h1>
	</div>
    <script type="text/javascript" src="js/time.js"></script>
</body>
</html>