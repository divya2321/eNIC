<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Add health record</title>

</head>

<body style="background-color:#F1F1F1">
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light ">Health care</span>
   </div>
   
 
   	
	<div class="container">
	  		<div class="row">	  				
	  				 <form:form action="/health/add/record/process" method="POST" modelAttribute="healthEntity" >
	  				 	 <br>  	
	  				 <div class="form-row">
					    	<form:label path="nicNo">NIC number:</form:label>
					    	<br>
					    	<form:input path="nicNo" type="text" class="form-control"/>
					  	</div>		  	
				
					 	<div class="form-row">
					    	<form:label path="healthRecord">Health record:</form:label>
					    	<form:input path="healthRecord" type="text" class="form-control" />
					  	</div>		  	
				
					  	<div class="form-row">
					    	<form:label path="discription">Discription:</form:label>
					    	<form:textarea path="discription" rows="5" class="form-control" ></form:textarea>
					  	</div>
					  	<div class="form-row">
					    	<form:label path="healthReport">Report:</form:label>
					    	<form:input path="healthReport" type="text" class="form-control" />
					  	</div>
	  						<br>
						  	<br>
						  		  	
	  	<button type="submit" class="btn btn-primary float-right m-2">&nbsp;Upload&nbsp;</button>
</form:form> 
					
	  		</div>
	  	</div> 
</body>

</html>

