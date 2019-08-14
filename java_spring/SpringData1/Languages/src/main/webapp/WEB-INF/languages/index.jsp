<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h3>All Languages</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creator</th>
					<th scope="col">Version</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">

					<tr>
						<td><a href="/languages/${language.id}"><c:out
									value="${language.name}" /></a></td>
						<td><c:out value="${language.creator}" /></td>
						<td><c:out value="${language.version}" /></td>
						<td>
							<form action="/languages/${language.id}/delete" method="post">
								<input type="hidden" name="_method" value="delete" /> <input
									type="submit" class="btn btn-link" value="Delete" />
							</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<h3>New Language</h3>
		<form:form action="/languages/process" method="post"
			modelAttribute="language">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">creator</form:label>
				<form:errors path="creator" />
				<form:textarea path="creator" />
			</p>
			<p>
				<form:label path="version">version</form:label>
				<form:errors path="version" />
				<form:input path="version" />
			</p>

			<input type="submit" value="Submit" />
		</form:form>

	</div>



</body>
</html>