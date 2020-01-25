<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>    
    

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
	<h2>Address Form</h2>
	<form:form action="saveAddress" method="post" modelAttribute="address">
		<div class="form-group">
			<label >Name</label>
			<form:input path="userName" class="form-control" />
			<%-- <form:errors path="nameName" cssClass="error" /> --%>
		</div>
		<div class="form-group">
			<label>Village Name</label>
			<form:input path="villName" class="form-control" />
		</div>
		<div class="form-group">
			<label>Select State</label>
			<form:select path="state.stateId" name="stateId" id="stateId" class="form-control" >
			<option value="">--Select State--</option>
				<c:forEach items="${states}" var="state">						
					<form:option value="${state.stateId}" label="${state.stateName}"/>
				</c:forEach>
			</form:select>			
		</div>
		<div class="form-group">
		<label>City Name</label>
			<form:select path="city.cityId" name="cityId" id="city" class="form-control" >
					<option value="">--Select City--</option>
			</form:select>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>

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
							options = options + '<option value='+response.data[i].cityId+'>' +response.data[i].cityName + '</option>';
						}         			
            		}$('#city').html(options); 
            		}           		
            		});
            	});
            });
    </script>
