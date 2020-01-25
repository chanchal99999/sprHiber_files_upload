<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body> --%>


<%-- 		<form:form action="addUser" method="post" modelAttribute="user" class="form-horizontal"> --%>
<form:form action="saveState" method="post" modelAttribute="state">
	<div class="from-group">
		<label>State</label>
		<form:input path="stateName" class="form-control" />
	</div>
	<br>
	<div class="form-group">
		<button type="submit" class="btn btn-primary">Save</button>
	</div>
</form:form>
<h3>List Of State</h3>
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<td><strong>State Name </strong></td>
			<td><strong>Action</strong></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${states}" var="state">
			<tr>
				<td>${state.stateName}</td>
				<td><a href="deleteState?id=${state.stateId}">Delete</a> <a
					href="updateState?id=${state.stateId}">Update</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<!-- </body>
</html> -->