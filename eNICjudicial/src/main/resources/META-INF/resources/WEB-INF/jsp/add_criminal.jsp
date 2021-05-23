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
<title>Add criminal record</title>

</head>

<body style="background-color:#F1F1F1">
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light ">Judicial</span>
   </div>
   
 
   	
	<div class="container">
	  		<div class="row">	
	  					
	  				  <form:form action="/judicial/add/record/process" modelAttribute="criminalEntity" method="POST" enctype="multipart/form-data">
	  				 
	  				 <br>  	
	  				<div class="form-row">
	  				 <div class="form-group">
					    	<form:label path="nicNo">NIC number:</form:label>
					    	<br>
					    	<form:input path="nicNo" type="text" class="form-control"/>
					  	</div>		  	
			
	  				 </div>
	  				 
					 	<div class="form-group">
					    	<form:label path="criminalRecord">Criminal record:</form:label>
					    	<form:input path="criminalRecord" type="text" class="form-control" />
					  	</div>		  	
				
				 	<div class="form-group">
					    	<form:label path="criminalDiscription">Criminal record description:</form:label>
					    	<form:input path="criminalDiscription" type="textarea" class="form-control" />
					  	</div>		
					  	
					  	<div class="form-group">
					    	<form:label path="criminalReport">Report:</form:label>
					    	<form:input path="criminalReport" type="text" class="form-control" />
					  	</div>
					  		
					 	<div class="row-inline ">
	  						<br>
						  	<br>
		<button type="submit" class="btn btn-primary float-right m-2">&nbsp;Upload&nbsp;</button>
	  	<button type="button" class="btn btn-danger float-right m-2">&nbsp;&nbsp;&nbsp;Cancel&nbsp;&nbsp;&nbsp;</button>
	  
	  	</div> 
					</form:form> 
	  		</div>
	  	 
	</div>
</body>

</html>

