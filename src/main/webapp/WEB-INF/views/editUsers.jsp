<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<%-- <link href="<c:url value='/resources/js/jquery.js' />" rel="stylesheet"></link> --%>
<style type="text/css">
.error {
	color: red;
}

table {
	width: 50%;
	border-collapse: collapse;
	border-spacing: 0px;
}

table td {
	border: 1px solid #565454;
	padding: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<a href="newFile" class="btn btn-primary">File Upload Form</a> <a
				href="newCityForm" class="btn btn-primary">CityPage</a> <a
				href="stateForm" class="btn btn-primary">StatePage</a> <a
				href="cityState" class="btn btn-primary">City State Page</a> <a
				href="stateAndCity" class="btn btn-primary">City And State Page</a>
			<a href="addressForm" class="btn btn-primary">Address Page</a> <a
				href="allAddress" class="btn btn-primary">Address Page</a><br>
			<a href="videoForm" class="btn btn-primary">Video Page</a> <br>
			<h1 class="text-primary">User Form</h1>
			<div class="col-md-12">
				<form:form action="addUser" method="post" modelAttribute="user">
					<form:hidden path="id" />
					<div class="form-group">
						<label>Name</label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" cssClass="error" />
					</div>
					<div class="form-group">
						<label>Email</label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" cssClass="error" />
						<br>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<h2>Users List</h2>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<td><strong>Name</strong></td>
						<td><strong>Email</strong></td>
						<td><strong>Action</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.name}</td>
							<td>${user.email}</td>
							<td><a href="deleteUser?id=${user.id}">Delete</a> <a
								href="updateUser?id=${user.id}">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>