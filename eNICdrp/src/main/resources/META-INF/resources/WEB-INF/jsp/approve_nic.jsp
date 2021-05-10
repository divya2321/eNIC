<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>NIC registration</title>

</head>

<body style="background-color:#FFFFFF">
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light" style="font-size:20px;">
Department for Registration of Persons</span>
   </div>
   
   <br/>
 <div class="container-fluid" >
 
   	<div class="row">
	  	<div class="col-sm-10">
	  		<div class="row">
	  			<div class="col-sm-2">
	  				<button class="btn btn-primary font-weight-bold">&lt;&lt; Previous</button>
	  			</div>
	  			<div class="col-sm-6 d-flex justify-content-center">
	  				<span>Renew application</span>
	  			</div>
	  			<div class="col-sm-2 d-flex justify-content-end ml-5">
	  				<button class="btn btn-primary font-weight-bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Next &gt;&gt; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
	  			</div>
	  		</div>
	  	</div>
	  	<div class="col-sm-2 "></div>  
	</div> 

<br/>

	<div class="container-fluid">
	<div class="row">
	  	<div class="col-sm-10 ">
	  		<div class="row">
	  			<div class="col-sm-7">
	  				
	  				 <form action="#" id="nicregform">
					 	<div class="form-group">
					    	<label for="nicno">NIC number:</label>
					    	<input type="text" class="form-control" id="nicno" readonly>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="fullname">Full name:</label>
					    	<input type="text" class="form-control" id="fullname" readonly>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="dob">Date of Birth:</label>
						    	<input type="date" class="form-control" id="dob" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="gender">Gender:</label>
						    	<br>
						    	<label for="orgtype">Civil Status:</label> 
							<button class="btn btn-secondary dropdown-toggle" 
								type="button" id="dropdownMenuButton" 
								data-toggle="dropdown" 
								aria-haspopup="true" 
								aria-expanded="false">
	    							Select a type
  							</button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							    <a class="dropdown-item" href="#">Unmarried</a>
							    <a class="dropdown-item" href="#">Married</a>
							    <a class="dropdown-item" href="#">Divorced</a>
							    <a class="dropdown-item" href="#">Widowed</a>
							  </div>
					  		<br>
						    	<div class="form-check-inline">
									  <label class="form-check-label">
									  	<input type="radio" class="form-check-input" name="optradio" readonly>Female
									  </label>
								</div>
								<div class="form-check-inline">
									 <label class="form-check-label">
									    <input type="radio" class="form-check-input" name="optradio" readonly>Male
									  </label>
								</div>
								<div class="form-check-inline">
									 <label class="form-check-label">
									    <input type="radio" class="form-check-input" name="optradio" readonly>Other
									  </label>
								</div>
					  		</div>
					  	</div>
					  	
				
					  	<div class="form-group">
					    	<label for="permanentaddress">Permanent Address:</label>
					    	<textarea rows="5" class="form-control" id="permanentaddress" readonly></textarea>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="postaladdress">Postal Address:</label>
					    	<textarea rows="5" class="form-control" id="postaladdress" readonly></textarea>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="homeno">Resident Number:</label>
						    	<input type="tel" class="form-control" id="homeno" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="mobileno">Mobile Number:</label>
						    	<input type="tel" class="form-control" id="mobileno" readonly>
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="emailaddress">E-mail Address:</label>
					    	<input type="email" class="form-control" id="emailaddress" readonly>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="mothname">Mother's name:</label>
					    	<input type="text" class="form-control" id="mothname" readonly>
					  	</div>
					  	<div class="form-group">
					    	<label for="momnicno">Mother'sNIC number:</label>
					    	<input type="text" class="form-control" id="momnicno" readonly>
					  	</div>
					  	<div class="form-group">
					    	<label for="fathname">Father's name:</label>
					    	<input type="text" class="form-control" id="fathname" readonly>
					  	</div>
					  	<div class="form-group">
					    	<label for="fathnicno">Father's NIC number:</label>
					    	<input type="text" class="form-control" id="fathnicno" readonly>
					  	</div>
					 	
					</form> 
	  				
	  			</div>
	  			<div class="col-sm-3 container d-flex justify-content-center"  >
	  				<div >
	  				 <img src="imgtest.JPG" class="img-thumbnail" width="200px" alt="Cinque Terre"> 
	  				 <br><br>
	  				  <div class="list-group">
						  <a href="#" class="list-group-item list-group-item-action">Application Form</a>
						  <a href="#" class="list-group-item list-group-item-action">Grama Niladhari Form</a>
						  <a href="#" class="list-group-item list-group-item-action">Other Form</a>
					  </div> 
					  </div>
	  			</div>
	  		</div>
	  	</div>
	  	<div class="col-sm-2 ">
	  	<br>
	  	<br>
	  	<button type="submit" class="btn btn-danger">&nbsp;&nbsp;&nbsp;Reject&nbsp;&nbsp;&nbsp;</button>
	  	<br>
	  	<br>
	  	<br>
	  	<br>
	  	<button type="submit" class="btn btn-primary" form="nicregform">&nbsp;Approve&nbsp;</button>
	  	</div>  
	</div> 
	</div>
</div> 
</body>

</html>

