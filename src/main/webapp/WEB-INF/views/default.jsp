<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><tiles:getAsString name="title" /></title>
		<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
<div class="container">
	<div class="row">
	<tiles:insertAttribute name="header"/>		
	</div><!-- header  ends -->
	<hr/>
	<div class="row">
		<tiles:insertAttribute name="body" />
	</div><!-- boody end here-->
	<hr/>
	<div class="row">
	<tiles:insertAttribute name="footer"/>		
	</div><!-- footer  ends -->
</div>
</body>
</html>