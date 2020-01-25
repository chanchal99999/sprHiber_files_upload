<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>    
    
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script> -->
		<script>
		data = "";
          $(document).ready(function() {
            $('#stateId').change(function() {  
            	var id=$(this).val();
            	$.ajax({
            		type:'POST',
            		url:'loadStateCities',
            		data: {"stateId" : id},
            		success : function(response){
            			var options='';
            			if(response.data.length==1){
    						alert(response.message+"!");
            			}else{
//						alert(response.data);
//						data=response.data;
						for(i=0; i<response.data.length; i++){	
							options = options + '<option value='+response.data[i].cityId'+>' +response.data[i].cityName + '</option>';
						}
            		}$('#city').html(options);
            		}           		
            		});
            	});
            });
        
        
    </script>
		
<!-- </head>
<body> -->
<form>
	<div class="form-group">
		<label>State Name</label>
		<select id="stateId" name="stateId" class="form-control">
    	    <option value="">Select State</option> 
            <c:forEach items="${stateList}" var="state">
        	 	<option value="${state.stateId}"  >${state.stateName}</option>
            </c:forEach>
        </select>
	</div>
	<div class="form-group">
	<div class="data">
		<label>City Name</label>
		<select  id="city" name="city"class="form-control">
        	<option value="">Select City</option> 
        </select>
	</div>
	</div>
</form>