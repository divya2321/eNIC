<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type='text/javascript' src='/array.generics.min.js'></script>
    <script type='text/javascript' src='/jquery.min.js'></script>
     <script type="text/JavaScript" src='/BiominiWebAgent.js'></script>
  
  
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
    
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap4.min.css"/>
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
  
  
<title>View Person</title>

</head>

<body style="background-color:#FFFFFF" onload="InitPage();Init();"
      onbeforeunload="DeletePage()">
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light ">Finance</span>
   </div>
   
   <br/>
 <div class="container-fluid" >
 
 <div  class="ml-3">
	
	<div class="input-group">
		
			<form action="/finance/view/person/search" method="GET">
			<div class="form-check-inline">
			
				<label class="form-label">NIC number:</label> 
				&nbsp; 
				<input id="search-focus" name="nic" type="text" value="${person.nicNo}" class="form-control" />
			
			&nbsp; &nbsp;
			<button type="submit" class="btn btn-primary"  >
				<i class="fas fa-search"></i>
			</button>
			</div>
			</form>
			</div>
			</div> 
			<hr/>
	<div class="row">
	  	<div class="col-sm-4 ">
					 	<div class="form-group">
					    	<label for="nicno">NIC number:</label>
					    	<input type="text" class="form-control" id="nicno" value="${person.nicNo}" readonly>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="fullname">Full name:</label>
					    	<input type="text" class="form-control" id="fullname" value="${person.name}" readonly>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="dob">Date of Birth:</label>
						    	<input type="date" class="form-control" value="${person.dob}" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="gender">Gender:</label>
						    	<input type="text" class="form-control" value="${person.gender}" readonly>
					  		<br>
						    	
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="civil">Civil status:</label>
					    	<input type="text" class="form-control" id="civil" value="${person.civilStatus}" readonly>
					  	</div>
				
					  	<div class="form-group">
					    	<label for="permanentaddress">Permanent Address:</label>
					    	<textarea rows="5" class="form-control"  readonly>${person.addressPermanentNo} ${person.addressPermanentStreet1} ${person.addressPermanentStreet2} ${person.addressPermanentCity}</textarea>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="postaladdress">Resident Address:</label>
					    	<textarea rows="5" class="form-control"  readonly>${person.addressResidentNo} ${person.addressResidentStreet1} ${person.addressResidentStreet2} ${person.addressResidentCity}</textarea>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="homeno">Resident Number:</label>
						    	<input type="tel" class="form-control" value="${person.residentNo}" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="mobileno">Mobile Number:</label>
						    	<input type="tel" class="form-control" value="${person.mobileNo}" readonly>
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="emailaddress">E-mail Address:</label>
					    	<input type="email" class="form-control" value="${person.emailAddress}" readonly>
					  	</div>
					  		
					  
					  	 <div class="form-group" style="display: none;">
					    	<label >Fingerprint:</label>
					    	<textarea class="form-control" id="Tb_Template" size="1000" >${person.fingerprint}</textarea>
					  	</div>

	  	</div>
	  	<div class="col-sm-8">
	
	<div class="row">
		<div class="col-sm-4">
	  			 <div class="form-group">
                                <label>FingerPrint Live Image</label>
                             </div>
                              <div class="form-group">
                                <button id="Bt_TempDataVerify" onclick="VerifyWithTemplate();" type="button" style="width:120px;height:30px;">Verify</button>
                              </div>
                             
                        
                          </div>
                          <div class="col-sm-4">
                            <textarea id="Tb_DisplayLog" style="width:320px;height:250px;" ></textarea>
                          </div>
	  		</div>
		   
		
		     	
	  	</div>  
	</div> 
</div> 
</body>
	
</html>

