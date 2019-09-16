<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Events</title>

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
	<div class="container">

		<!-- header -->
		<div class="row">
			<div class="col-11">
				<h1 class="text-capitalize">
					Welcome,
					<c:out value="${user.firstName}" />
				</h1>
			</div>
			<div class="col pt-3">
				<a class="float-left" href="/">Logout</a>
			</div>
		</div>
		<!-- end of header -->

	${ eventsJoined }

		<h1>TESTING LIST</h1>
		<c:forEach items="${ eventsJoined }" var="events">
			<tr>
				<td>${events.event.id}</td>
			</tr>
		</c:forEach>

		<p>${user.id }</p>



		<%-- <c:when test="${event.users.contains(user.id)}">
 --%>

		<!-- events table  (will need to change query)-->
		<div class="mt-4">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Date</th>
						<th scope="col">Location</th>
						<th scope="col">Host</th>
						<!-- <th scope="col">event.users TEST</th> -->
						<th scope="col">Action/Status</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${ eventsNearby }" var="event">
						<tr>
							<td><a href="/events/${event.id}">${event.name}</a></td>
							<td>${event.date}</td>
							<td>${event.city},${event.state}</td>
							<td class="text-capitalize">${event.user.firstName}
								${event.user.lastName}</td>							
							<td>
								<div class="d-flex flex-row">
									<c:choose>
										<c:when test="${event.user.id == user.id}">
											<div>
												<a href="/events/${event.id}/edit" class="btn btn-link">Edit</a>
											</div>
											<div>
												<form action="/events/${event.id}/delete" method="post">
													<input type="hidden" name="_method" value="delete">
													<input type="submit" value="Delete"
														class="btn btn-link text-danger">
												</form>
											</div>
										</c:when>
										<c:otherwise>

											<c:choose>
												<c:when test="${ eventsJoined.contains(event) }">
													<p>Joined</p>
												</c:when>
												<c:otherwise>
													<form action="/events/${event.id}/join" method="post">
														<input type="submit" value="Join"
															class="btn btn-link text-success">
													</form>
												</c:otherwise>
											</c:choose>

										</c:otherwise>
									</c:choose>

								</div>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- End of events table -->

		<hr>

		<!-- OTHER events table -->

		<div class="mt-4">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Date</th>
						<th scope="col">Location</th>
						<th scope="col">Host</th>
						<th scope="col">Action/Status</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${ otherEvents }" var="event">
						<tr class="">
							<td><a href="/events/${event.id}">${event.name}</a></td>
							<td>${event.date}</td>
							<td>${event.city},${event.state}</td>
							<td class="text-capitalize">${event.user.firstName}
								${event.user.lastName}</td>
							<td><c:choose>
									<c:when test="${event.user.id == user_id}">
										<div class="d-flex flex-row">
											<a href="/events/${event.id}/edit" class="btn btn-link">Edit</a>

											<form action="/events/${event.id}/delete" method="post">
												<input type="hidden" name="_method" value="delete">
												<input type="submit" value="Delete"
													class="btn btn-link text-danger">
											</form>
										</div>
									</c:when>
									<c:otherwise>
										<a href="/events/join" class="btn btn-link">Join</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- End of OTHER events table -->

		<!-- Create new event -->

		<div class="col-6 rounded p-3 shadow-sm">
			<h3>Create an Event</h3>
			<form:form action="/events/new/" method="post" modelAttribute="event"
				class="pt-3">

				<form:hidden path="user" value="${user_id}" />

				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name" class="form-control" />
					<small class="text-danger"> <form:errors path="name" />
					</small>
				</div>

				<div class="form-group">
					<form:label path="date">Date</form:label>
					<form:input path="date" type="date" class="form-control" />
					<small class="text-danger"> <form:errors path="date" />
					</small>
				</div>
				<div class="form-row">
					<div class="col">
						<form:label path="city">City</form:label>
						<form:input path="city" class="form-control" />
						<small class="text-danger"> <form:errors path="city" />
						</small>
					</div>

					<div class="col">
						<form:label path="state">State</form:label>
						<form:input path="state" class="form-control" />
						<small class="text-danger"> <form:errors path="state" />
						</small>
					</div>
				</div>

				<input type="submit" value="Create" class="btn btn-secondary" />
			</form:form>
		</div>

		<!-- End of create event form -->

	</div>
</body>
</html>