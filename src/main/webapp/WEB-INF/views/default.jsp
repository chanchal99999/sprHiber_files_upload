<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><tiles:getAsString name="title" /></title>
		<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<%-- 		<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.js"/>"></script> --%>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</head>
<body>
<div class="container">
	<div class="row">
	<tiles:insertAttribute name="header"/>		
	<!-- header  ends -->
	<hr/>
	<div class="col-md-12">
		<tiles:insertAttribute name="body" />
	</div><!-- boody end here-->
	<hr/>
	<tiles:insertAttribute name="footer"/>		
	</div><!-- footer  ends -->
</div>
</body>
</html>