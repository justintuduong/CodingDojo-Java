<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>

</head>
<body>
	<div class="container">
		<h1>
  			<fmt:formatDate pattern="EEEE', the 'dd' of 'MMMM, yyyy" value="${date}" />
		</h1>
	</div>
</body>
    <script type="text/javascript" src="js/date.js"></script>
</html>