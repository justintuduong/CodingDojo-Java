<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<!-- BootStrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- BootStrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col p-5">
				<h1>Register!</h1>

				<form:form method="POST" action="/register"
					modelAttribute="user">
					<div class="form-group">
						<form:label path="firstName">First Name:</form:label>
						<form:input type="text" path="firstName" class="form-control text-capitalize" />
						<small>
							<form:errors path="firstName" class="text-danger"/>
						</small>
					</div>
					<div class="form-group">
						<form:label path="lastName">Last Name:</form:label>
						<form:input type="text" path="lastName" class="form-control text-capitalize" />
						<small>
						<form:errors path="lastName" class="text-danger"/>
						</small>
					</div>
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email" class="form-control" />
						<small>
						<form:errors path="email" class="text-danger"/>
						</small>
					</div>
					<div class="form-group form-row">
						<div class="col-6">
							<form:label path="city">City:</form:label>
							<form:input type="text" path="city" class="form-control text-capitalize"/>
							<small>
							<form:errors path="city" class="text-danger"/>
							</small>
						</div>
						<div class="col-6">
							<form:label path="state">State:</form:label>
							<form:input type="state" path="state" class="form-control text-uppercase" />
							<small>
							<form:errors path="state" class="text-danger"/>
							</small>
						</div>
					</div>
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:password path="password" class="form-control"/>
						<small>
						<form:errors path="password" class="text-danger"/>
						</small>
					</div>
					<div class="form-group">
						<form:label path="passwordConfirmation">Password Confirmation:</form:label>
						<form:password path="passwordConfirmation" class="form-control"/>
						<small>
						<form:errors path="passwordConfirmation" class="text-danger"/>
						</small>
					</div>
					<input type="submit" value="Register!" class="btn btn-primary" />
				</form:form>
			</div>

			<div class="col p-5">
				<h1>Login</h1>
				<div>
					<small class="text-danger">
						<c:out value="${error}" />
					</small>
				</div>
				<form method="post" action="/login">
					<div class="form-group">
						<label for="email"> Email</label> 
						<input type="text" id="email" name="email" class="form-control"/>
					</div>
					<div class="form-group">
						<label for="password">Password</label> 
						<input type="password" id="password" name="password" class="form-control" />
					</div>
					<input type="submit" value="Login!" class="btn btn-primary"/>
				</form>
			</div>

		</div>
	</div>
</body>
</html>