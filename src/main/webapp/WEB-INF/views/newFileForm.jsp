<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%><%-- 
<!DOCTYPE html>
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
	<div class="container">
 --%>


<h1>New File Form</h1>
<form:form action="uploadFile" method="post"
	enctype="multipart/form-data" modelAttribute="userFile"
	onsubmit="validateForm()" name="myForm">
	<form:hidden path="id" />
	<div class="form-group">
		<label>Description</label>
		<form:input path="description" type="text" name="description"
			class="form-control" />
		<form:errors path="description" cssClass="error" />
	</div>

	<div class="form-group">
		<label>Content</label><br> <img id="imgurl"
			style="width: 100px; height: 100px;" class="img-circle" />
		<c:if test="${userFile.id >0}">
			<img src="viewImg?id=${userFile.id}" alt="No image" height="100px"
				width="100px" class="img-circle">
		</c:if>
		<br>
		<br>
		<form:input path="content" type="file" onchange="PreviewImage(this);"
			id="uploadImage" />
		<br>
		<button type="submit" class="btn btn-primary">Upload</button>
	</div>
</form:form>

<h2>UserFile List</h2>
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<td><strong>Image</strong></td>
			<td><strong>Description</strong></td>
			<td><strong>Actions</strong></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="file">
			<tr>
				<td><a href="<c:url value='viewImg?id=${file.id}' />"> <img
						id="i1" src="viewImg?id=${file.id}" alt="No image" height="200px"
						width="200px" class="img-circle">
				</a></td>
				<td>
					<h3>${file.description}</h3>
				</td>
				<td>
					<%-- <a href="updateUserFile?id=${file.id}" class="btn btn-primary">Update </a> --%>
					<a href="updateUserFile?id=${file.id}" class="btn btn-primary">Update
				</a> <a href="<c:url value='viewImg?id=${file.id}' />"
					class="btn btn-success">View</a> <a
					href="<c:url value='downloadDoc?id=${file.id}' />"
					class="btn btn-success">Download</a> <a
					href="deleteUserFile?id=${file.id}" class="btn btn-primary">Delete
				</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<hr>
<img src="" id="imgurl" alt="Your image"
	style="width: 100px; height: 100px;" class="img-circle">
<input type="file" onChange="imgpathUrl(this);">
<script>
	function imgpathUrl(input) {
		$('#imgurl')[0].src = (window.URL ? URL : webkitURL)
				.createObjectURL(input.files[0]);
	}

	function validateForm() {
		var x = document.forms["myForm"]["description"].value;
		if (x == "") {
			alert("Description must be filled out");
			return false;
		}
	}
</script>

<!-- 	</div>
</body> -->
<script type="text/javascript">
	function PreviewImage(input) {
		$('#imgurl')[0].src = (window.URL ? URL : webkitURL)
				.createObjectURL(input.files[0]);
	}
</script>
