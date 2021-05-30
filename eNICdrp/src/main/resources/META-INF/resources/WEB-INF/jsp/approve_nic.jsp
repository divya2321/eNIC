<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>NIC registration</title>

</head>

<body style="background-color:#FFFFFF"  onbeforeunload="DeletePage();" onload="InitPage();Init();"     >
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light" style="font-size:20px;">
Department for Registration of Persons</span>
   </div>
   
   <br/>
 <div class="container-fluid" >
 

	<div class="container-fluid">
	<div class="row">
	 <form:form action="/drp/register/process" modelAttribute="drpEntity" method="POST">
	 <div class="row">
	  	<div class="col-sm-10">
	  		<div class="row">
	  			<div class="col-sm-6">
	  				
	  				
	  				 <div class="form-check-inline">
	  				 	<div class="form-group">
					    	<form:label path="applicationNo">Application no:</form:label>
					    	<form:input path="applicationNo" type="text" class="form-control" />
					  	</div>
					  	
					  	<div class="form-group">
						    	<form:label path="recievedDate">Receive date:</form:label>
						    	<form:input path="recievedDate" type="date" class="form-control"  />
					  		</div>
					  	
	  				 <div class="form-group">
						<form:label path="applicationType">Application type:</form:label> 
							<form:select path="applicationType" class="form-control browser-default custom-select" >
                                    <option value="New">New</option>
                                    <option value="Renew">Renew</option>
                                    <option value="lost">Lost</option>
                       		</form:select>
					</div>
	  				 </div>
	  				 
					  	<div class="form-group">
					    	<form:label path="familyName">Familyname:</form:label>
					    	<form:input path="familyName" type="text" class="form-control" />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="name">Name:</form:label>
					    	<form:input path="name" type="text" class="form-control" />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="surName">Surname:</form:label>
					    	<form:input path="surName" type="text" class="form-control" />
					  	</div>
					  	
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<form:label path="dob">Date of Birth:</form:label>
						    	<form:input path="dob" type="date" class="form-control"  />
					  		</div>
					  		&nbsp;&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	
						        	<form:label path="civilStatus">Civil Status:</form:label> 
						
							<form:select path="civilStatus" class="form-control browser-default custom-select" >
                                    <option value="Unmarried">Unmarried</option>
                                    <option value="Married">Married</option>
                                    <option value="Divorced">Divorced</option>
                                    <option value="Widowed">Widowed</option>
                       		</form:select>
					  		<br>
					  		<br>
					  		<form:label path="gender">Gender:</form:label>
						    	<div class="form-check-inline">
									  <form:label path="gender" class="form-check-label"></form:label>
								</div>
								<div class="form-check-inline">
									    <form:radiobutton path="gender" class="form-check-input" value="Male"/>Male
								</div>
								<div class="form-check-inline">
									    <form:radiobutton path="gender" class="form-check-input" value="Female"/>Female
								</div>
								<div class="form-check-inline">
									    <form:radiobutton path="gender" lass="form-check-input" value="Other" />Other
								</div>
					  		</div>
					  	</div>
					  	
				
					  	<div class="form-group">
					    	<form:label path="addressPermanentNo">Permanent address no:</form:label>
					    	<form:input path="addressPermanentNo" type="text" class="form-control"  />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="addressPermanentStreet1">Permanent address street1:</form:label>
					    	<form:input path="addressPermanentStreet1" type="text" class="form-control"/>
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="addressPermanentStreet2">Permanent address street2:</form:label>
					    	<form:input path="addressPermanentStreet2" type="text" class="form-control" />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="addressPermanentCity">Permanent address city:</form:label>
					    	<form:input path="addressPermanentCity" type="text" class="form-control" />
					  	</div>
					  	
					  			<div class="form-group">
					    	<form:label path="addressResidentNo">Resident address no:</form:label>
					    	<form:input path="addressResidentNo" type="text" class="form-control"  />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="addressResidentStreet1">Resident address street1:</form:label>
					    	<form:input path="addressResidentStreet1" type="text" class="form-control" />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="addressResidentStreet2">Resident address street2:</form:label>
					    	<form:input path="addressResidentStreet2" type="text" class="form-control" />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="addressResidentCity">Resident address city:</form:label>
					    	<form:input path="addressResidentCity" type="text" class="form-control" />
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<form:label path="residentNo">Resident Number:</form:label>
						    	<form:input path="residentNo" type="tel" class="form-control" />
					  		</div>
					  		&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<form:label path="mobileNo">Mobile Number:</form:label>
						    	<form:input path="mobileNo" type="tel" class="form-control"  />
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="emailAddress">E-mail Address:</form:label>
					    	<form:input path="emailAddress" type="email" class="form-control" />
					  	</div>
					  	
					  	<div class="form-group">
					    	<form:label path="motherName">Mother's name:</form:label>
					    	<form:input path="motherName"  type="text" class="form-control" />
					  	</div>
					  	<div class="form-group">
					    	<form:label path="motherNic">Mother'sNIC number:</form:label>
					    	<form:input  path="motherNic" type="text" class="form-control" />
					  	</div>
					  	<div class="form-group">
					    	<form:label path="fatherName">Father's name:</form:label>
					    	<form:input path="fatherName" type="text" class="form-control"/>
					  	</div>
					  	<div class="form-group">
					    	<form:label path="fatherNic">Father's NIC number:</form:label>
					    	<form:input path="fatherNic" type="text" class="form-control"/>
					  	</div>
					 	
					
	  				
	  			</div>
	  			<div class="col-sm-4 container d-flex justify-content-center"  >
	  				<div >
	  				
					
					  
					  <div class="form-group">
					  
					    	<form:label path="icaoPhoto">Person's image:</form:label>
					    	<form:input path="icaoPhoto" type="text" class="form-control"/>
					  	</div>
					 
					  	
					  	 <div class="form-group">
					    	<form:label path="scannedApplication">Application Form:</form:label>
					    	<form:input path="scannedApplication"  type="text" class="form-control"  />
					  	</div>
					  	
					  	 <div class="form-group">
					    	<form:label path="scannedGramaNiladhariCertificate">Grama Niladhari certificate:</form:label>
					    	<form:input path="scannedGramaNiladhariCertificate"  type="text" class="form-control" />
					  	</div>
					  	
					  	
					  	 <div class="form-group">
					    	<form:label path="oldNicNo">Old Nic:</form:label>
					    	<form:input path="oldNicNo"  type="text" class="form-control"/>
					  	</div>
					  
					  	
					  	 <div class="form-group">
					    	<form:label path="scannedOldNic">Old Nic scanned:</form:label>
					    	<form:input path="scannedOldNic"  type="text" class="form-control" />
					  	</div>
					  	
					  	 <div class="form-group">
					    	<form:label path="comment">Old Nic comment:</form:label>
					    	<form:textarea path="comment" class="form-control" ></form:textarea>
					  	</div>
					  	
					  	 <div class="form-group">
					    	<form:label path="scannedPoliceReport">Police report:</form:label>
					    	<form:input path="scannedPoliceReport"  type="text" class="form-control" />
					  	</div>
					  	
					  	 <div class="form-group" >
					    	<form:label path="fingerprint">Fingerprint:</form:label>
					    	<form:textarea path="fingerprint" class="form-control" id="fingerprintTemp"></form:textarea>
					  	</div>
					  	
					  	  </div>
	  			</div>
	  			
	  			<div class="col-sm-2 ">
	  			
                                <label>FingerPrint Live Image</label>
                                <button  onclick="StartCapture()" type="button" style="width:120px;height:30px;">Start Capture</button>
                                <p>
                                    <img id="Fpimg" width="160" height="200" />
                                </p>
                                  <label><input type="checkBox" id="Cb_PreviewOn" onclick="PreviewOnChecked();" />Preview On(MultiPart)</label>
                                     <button id="Bt_Extract" type="button" onclick="GetTemplateData()" style="width:140px;height:30px;">Get Template Data</button>
                          <textarea id="Tb_DisplayLog" style="width:320px;height:250px;" ></textarea>
	  			</div>
	  		</div>
	  	</div>
	  	<div class="col-sm-2 ">
	  	<div class="row">
	  	<br>
	  	<br>
	  
	  	<br>
	  	<button type="submit" class="btn btn-primary">&nbsp;Approve&nbsp;</button>
	  	</div>
	  	</div>
	  	</div>  
	  </form:form> 	
	</div> 
	</div>
</div> 
</body>

</html>

