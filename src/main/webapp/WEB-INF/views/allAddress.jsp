<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
				<h2>Address List</h2>
			<table class="table table-bordered table-hover table-striped ">
				<thead>
					<tr class="text-primary">
						<td><strong> User Name</strong></td>
						<td><strong> Village Name</strong></td>
						<td><strong> City Name</strong></td>
						<td><strong> State Name</strong></td>
						
						<td><strong> Actions</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${addresses}" var="address">
					<tr>
						<td>${address.userName}</td>
						<td>${address.villName}</td>
						<td>${address.city}</td>
						<td>${address.state}</td>
						
						<td>
						<a href="deleteAddress?addId=${address.addId}" class="btn btn-primary">Delete</a>
						<a href="updateAddress?addId=${address.addId}" class="btn btn-primary">Update</a>
						</td>
					</tr>	
					</c:forEach>
				</tbody>
			</table> 
		</div>