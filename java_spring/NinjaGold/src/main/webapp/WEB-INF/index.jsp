<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
<body class="container-fluid">
	<div class="text-center float-center">

		<!---------------- Gold keeper & Quit button ---------------------->

		<div class="row mb-3 mt-3">
			<p class="d-inline mt-2 mr-2 ml-4">Your Gold:</p>
			<p class="border rounded border-dark d-inline p-2">
				<c:out value="${gold}" />
			</p>
			<a href="/"
				class="btn btn-danger float-right mb-3 mr-3 col-1 ml-auto">Quit
				Game</a>

		</div>
		<div class="row mt-3">

			<!---------------------------- Farm -------------------------------->

			<div class="col border border-dark rounded mr-3 ml-3 p-3">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="action" value="farm"
						class="form-control">
					<button type="submit" class="btn btn-outline-success mt-4 mb-5">Find
						Gold!</button>
				</form>
			</div>

			<!---------------------------- House -------------------------------->

			<div class="col border border-dark rounded mr-3 ml-3 p-3">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="action" value="house"
						class="form-control">
					<button type="submit" class="btn btn-outline-primary mt-4 mb-5">Find
						Gold</button>
				</form>
			</div>

			<!---------------------------- Cave -------------------------------->

			<div class="col border border-dark rounded mr-3 ml-3 p-3 ">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="action" value="cave"
						class="form-control">
					<button type="submit" class="btn btn-outline-dark mt-4 mb-5">Find
						Gold</button>
				</form>
			</div>

			<!---------------------------- Casino -------------------------------->

			<div class="col border border-dark rounded mr-3 ml-3 p-3">
				<h3>Casino</h3>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/process" method="POST">
					<input type="hidden" name="action" value="casino"
						class="form-control">
					<button type="submit" class="btn btn-outline-warning mt-4 mb-5">Find
						Gold</button>
				</form>
			</div>

			<!---------------------------- Activity ------------------------------->

		</div>
	</div>
	<div class="mt-5">
		<p class="p-0 m-0">Activity log</p>
		<div class="container-fluid border border-dark rounded overflow-auto"
			style="height: 300px">
			<p class="ml-2 scrollspy overflow-auto">
			
<%-- 				<c: for(int i=0; i<activityLog.length();i++ ) {>
			
			
			
				<c:forEach items="${activityLog}" var="festival">
					<tr>
						<td>${festival.festivalName}</td>
						<td>${festival.location}</td>
						<td>${festival.startDate}</td>
						<td>${festival.endDate}</td>
						<td>${festival.URL}</td>
					</tr>
				</c:forEach> --%>
				
		</div>
	</div>
</body>
</html>
</body>
</html>