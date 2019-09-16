<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Event</title>

<!-- BootStrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- BootStrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</head>
<body>
<div class="container-fluid">
<div class="col-6 rounded p-3 shadow-sm">
		<h3>Edit your event!</h3>
			<form:form action="/events/${event.id}/edit/process" method="post"
				modelAttribute="event" class="pt-3">
				<input type="hidden" name="_method" value="put"/>
				
				<form:hidden path="user" value="${user_id}"/>
				
				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name" class="form-control"/>
					<small class="text-danger">
						<form:errors path="name" />
					</small>	
				</div>
				
				<div class="form-group">
					<form:label path="date">Date</form:label>
					<form:input path="date" type="date" class="form-control" />
					<small class="text-danger">
						<form:errors path="date" />
					</small>
				</div>
				<div class="form-row">
					<div class="col">
						<form:label path="city">City</form:label>
						<form:input path="city" class="form-control" />
						<small class="text-danger">
							<form:errors path="city" />
						</small>
					</div>
					
					<div class="col">
						<form:label path="state">State</form:label>
						<form:input path="state" class="form-control" />
						<small class="text-danger">
							<form:errors path="state" />
						</small>
					</div>
				</div>

				<input type="submit" value="Edit" class="btn btn-secondary mt-3"/>
			</form:form>
		</div>



</div>
</body>
</html>