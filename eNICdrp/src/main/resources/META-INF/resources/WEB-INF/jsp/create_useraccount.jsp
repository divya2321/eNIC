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
            
            <span class="nav-item text-light ">DRP</span>
   </div>
   
 
   	
	<div class="container">
	  		<div class="row">	  				
	  				 <form:form action="/drp/create/useraccount/process" method="POST" modelAttribute="useraccountEntity" >
	  				 	 <br>  	
	  				 <div class="form-row">
					    	<form:label path="username">Username:</form:label>
					    	<br>
					    	<form:input path="username" type="text" class="form-control"/>
					  	</div>		  	
				
					 	<div class="form-row">
					    	<form:label path="password">Password:</form:label>
					    	<form:input path="password" type="password" class="form-control" />
					  	</div>		  	
				
					  	
	  						<br>
						  	<br>
						  		  	
	  	<button type="submit" class="btn btn-primary float-right m-2">&nbsp;Create Account&nbsp;</button>
</form:form> 
					
	  		</div>
	  		<hr/>
	  		<br>
	  			<div class="form-row">
					    	<label >JWT Token:</label>
					    	<textarea class="form-control">${token}</textarea>
			</div>		
	  		
	  	</div> 
</body>

</html>

