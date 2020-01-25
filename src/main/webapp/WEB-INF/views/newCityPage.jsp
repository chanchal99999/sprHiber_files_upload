<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
	<h1>City Page</h1>
	<div class="conatiner">
		<div class="row">
			<form:form action="saveCity" method="post" modelAttribute="city">
				<label>Select State</label>
				<div class="form-group">
					<form:select path="stateId">
						<c:forEach items="${states}" var="state">						
							<form:option value="${state.stateId}" label="${state.stateName}"/>
						</c:forEach>
					</form:select>
				</div>
				<label>City Name</label>
				<div class="form-group">
					<form:input path="cityName" class="form-control"/>
				</div>
				<button type="submit" class="btn btn-primary">Add</button>
			</form:form>
		</div>
		<br>
		<div class="row">
			<table class="table table-bordered table-hover table-striped ">
				<thead>
					<tr class="text-primary">
						<td><strong> City Name</strong></td>
						<td><strong> Actions</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cities}" var="city">
					<tr>
						<td>${city.cityName}</td>
						<td>
						<a href="deleteCity?id=${city.cityId}" class="btn btn-primary">Delete</a>
						<a href="updateCity?id=${city.cityId}" class="btn btn-primary">Update</a>
						</td>
					</tr>	
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>