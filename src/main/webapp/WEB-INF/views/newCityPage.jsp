<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<form:form action="saveCity" method="post" modelAttribute="city">
	<div class="form-group">
		<label>Select State</label>
		<form:select path="stateId" class="form-control">
			<c:forEach items="${states}" var="state">
				<form:option value="${state.stateId}" label="${state.stateName}" />
			</c:forEach>
		</form:select>
	</div>
	<div class="form-group">
		<label>City Name</label>
		<form:input path="cityName" class="form-control" />
	</div>

	<button type="submit" class="btn btn-primary">Add</button>
</form:form>
<br>
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
				<td><a href="deleteCity?id=${city.cityId}"
					class="btn btn-primary">Delete</a> <a
					href="updateCity?id=${city.cityId}" class="btn btn-primary">Update</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
