<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  
  
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap4.min.css"/>
  
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
  
<title>View health records</title>

</head>

<body style="background-color:#FFFFFF" onload="InitPage();Init();"
      onbeforeunload="DeletePage()">
      
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light ">Health Care</span>
   </div>
   
   <br/>
 <div class="container-fluid" >
 
 <div  class="ml-3">
	
	<div class="input-group">
		
			<form action="/health/view/records/search" method="GET">
			<div class="form-check-inline">
			
				<label class="form-label">NIC number:</label> 
				&nbsp; 
				<input id="search-focus" name="nic" type="text" value="${health.Generals.nicNo}" class="form-control" />
			
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
					    	<input type="text" class="form-control" id="nicno" value="${health.Generals.nicNo}" readonly>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="fullname">Full name:</label>
					    	<input type="text" class="form-control" id="fullname" value="${health.Generals.name}" readonly>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="dob">Date of Birth:</label>
						    	<input type="date" class="form-control" value="${health.Generals.dob}" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="gender">Gender:</label>
						    	<input type="text" class="form-control" value="${health.Generals.gender}" readonly>
					  		<br>
						    	
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="civil">Civil status:</label>
					    	<input type="text" class="form-control" id="civil" value="${health.Generals.civilStatus}" readonly>
					  	</div>
				
					  	<div class="form-group">
					    	<label for="permanentaddress">Permanent Address:</label>
					    	<textarea rows="5" class="form-control"  readonly>${health.Generals.addressPermanentNo} ${health.Generals.addressPermanentStreet1} ${health.Generals.addressPermanentStreet2} ${health.Generals.addressPermanentCity}</textarea>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="postaladdress">Resident Address:</label>
					    	<textarea rows="5" class="form-control"  readonly>${health.Generals.addressResidentNo} ${health.Generals.addressResidentStreet1} ${health.Generals.addressResidentStreet2} ${health.Generals.addressResidentCity}</textarea>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="homeno">Resident Number:</label>
						    	<input type="tel" class="form-control" value="${health.Generals.residentNo}" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="mobileno">Mobile Number:</label>
						    	<input type="tel" class="form-control" value="${health.Generals.mobileNo}" readonly>
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="emailaddress">E-mail Address:</label>
					    	<input type="email" class="form-control" value="${health.Generals.emailAddress}" readonly>
					  	</div>
					  		
					  	
					  	 <div class="form-group"  style="display: none;">
					    	<label >Fingerprint:</label>
					    	<textarea class="form-control" id="Tb_Template" size="1000" >${health.Generals.fingerprint}</textarea>
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
	  		
	  		
	  	<div class="row d-flex justify-content-end  pr-3" >
	  	
	  	<form:form action="/health/add/blood/process" modelAttribute="healthEntity" method="PUT" >
	  	
	  		<div class="form-inline">
				<form:label path="bloodType">Blood type:&nbsp;&nbsp;</form:label>
				<form:input path="bloodType" type="text" class="form-control" width="200px" value="${health.Generals.bloodType}" />
				<form:input path="nicNo" type="text" class="form-control" value="${health.Generals.nicNo}" style="display: none;"/>
			
				&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-success" data-toggle="modal" data-target="#bloodModel">&nbsp;&nbsp;&nbsp;Add&nbsp;&nbsp;&nbsp;</button>
				</div>
			
				
				</form:form>
		   </div>	
		   
		   <br><br>
		   
		   <div class="table-responsive">
                <table id="healthrectable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                    <thead class="thead-light">
                        <tr>
                            <th>Health record</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th>Clinic</th>
                            <th>Report</th>
                        </tr>
                    </thead>

                    <tbody>
                                     <c:forEach items="${health.Ills}" var="ills">
                                     
	                                     	<tr>
	      									  <td> ${ills.healthRecord} </td>
	      									   <td>	${ills.discription}</td>
	      									  <td> ${ills.recordDate} </td>
	      									  <td> ${ills.orgName} </td>
	      									  <td> <a href="${ills.healthReport}" target="_blank">Link</a> </td>
	      								
												
	      							
	      									   									  
	      									</tr> 
   							</c:forEach>
                    </tbody> 
                </table>

            </div>
		     	
	  	</div>  
	</div> 
	
	
	
</div> 
</body>

</html>

