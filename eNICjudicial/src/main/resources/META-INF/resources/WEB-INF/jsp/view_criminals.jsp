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
  
  
<title>View criminal records</title>

</head>

<body style="background-color:#FFFFFF" onload="InitPage();Init();"
      onbeforeunload="DeletePage()">
   <div class="navbar bg-dark w3-large" >
            
            <span class="nav-item text-light ">Judicial</span>
   </div>
   
   <br/>
 <div class="container-fluid" >
 
 <div  class="ml-3">
	
	<div class="input-group">
		
			<form action="/judicial/view/records/search" method="GET">
			<div class="form-check-inline">
			
				<label class="form-label">NIC number:</label> 
				&nbsp; 
				<input id="search-focus" name="nic" type="text" value="${crminials.Generals.nicNo}" class="form-control" />
			
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
					    	<input type="text" class="form-control" id="nicno" value="${crminials.Generals.nicNo}" readonly>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="fullname">Full name:</label>
					    	<input type="text" class="form-control" id="fullname" value="${crminials.Generals.name}" readonly>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="dob">Date of Birth:</label>
						    	<input type="date" class="form-control" value="${crminials.Generals.dob}" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="gender">Gender:</label>
						    	<input type="text" class="form-control" value="${crminials.Generals.gender}" readonly>
					  		<br>
						    	
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="civil">Civil status:</label>
					    	<input type="text" class="form-control" id="civil" value="${crminials.Generals.civilStatus}" readonly>
					  	</div>
				
					  	<div class="form-group">
					    	<label for="permanentaddress">Permanent Address:</label>
					    	<textarea rows="5" class="form-control"  readonly>${crminials.Generals.addressPermanentNo} ${crminials.Generals.addressPermanentStreet1} ${crminials.Generals.addressPermanentStreet2} ${crminials.Generals.addressPermanentCity}</textarea>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="postaladdress">Resident Address:</label>
					    	<textarea rows="5" class="form-control"  readonly>${crminials.Generals.addressResidentNo} ${crminials.Generals.addressResidentStreet1} ${crminials.Generals.addressResidentStreet2} ${crminials.Generals.addressResidentCity}</textarea>
					  	</div>
					  	
					  	<div class="form-row">
					  		<div class="form-group">
						    	<label for="homeno">Resident Number:</label>
						    	<input type="tel" class="form-control" value="${crminials.Generals.residentNo}" readonly>
					  		</div>
					  		&nbsp;&nbsp;&nbsp;
					  		<div class="form-group">
						    	<label for="mobileno">Mobile Number:</label>
						    	<input type="tel" class="form-control" value="${crminials.Generals.mobileNo}" readonly>
					  		</div>
					  	</div>
					  	
					  	<div class="form-group">
					    	<label for="emailaddress">E-mail Address:</label>
					    	<input type="email" class="form-control" value="${crminials.Generals.emailAddress}" readonly>
					  	</div>
					  		
					  	<div class="form-group">
					    	<label for="mothname">Mother's name:</label>
					    	<input type="text" class="form-control" value="${crminials.Generals.motherName}" readonly>
					  	</div>
					  	<div class="form-group">
					    	<label for="momnicno">Mother'sNIC number:</label>
					    	<input type="text" class="form-control" value="${crminials.Generals.motherNic}" readonly>
					  	</div>
					  	<div class="form-group">
					    	<label for="fathname">Father's name:</label>
					    	<input type="text" class="form-control" value="${crminials.Generals.fatherName}" readonly>
					  	</div>
					  	<div class="form-group">
					    	<label for="fathnicno">Father's NIC number:</label>
					    	<input type="text" class="form-control" value="${crminials.Generals.fatherNic}" readonly>
					  	</div>
					  	
					  	 <div class="form-group">
					    	<label >Fingerprint:</label>
					    	<textarea class="form-control" id="Tb_Template" size="1000" >${crminials.Generals.fingerprint}</textarea>
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
                                <p>
                                    <img id="Fpimg" width="160" height="200" />
                                </p>
                                    
                        
                          </div>
                          <div class="col-sm-4">
                            <textarea id="Tb_DisplayLog" style="width:320px;height:250px;" ></textarea>
                          </div>
	  		</div>
		   
		   <div class="table-responsive">
                <table id="policetable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                    <thead class="thead-light">
                        <tr>
                            <th>Criminal record</th>
                            <th>Criminal Description</th>
                            <th>Date</th>
                            <th>Court</th>
                            <th>Report</th>
                        </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${crminials.Crimes}" var="crime">
                                     
	                                     	<tr>
	      									  <td> ${crime.criminalRecord} </td>
	      									   <td>	${crime.criminalDiscription}</td>
	      									  <td> ${crime.recordDate} </td>
	      									  <td> ${crime.orgName} </td>
	      									  <td> <a href="${crime.criminalReport}" target="_blank">Link</a> </td>
	      								
												
	      							
	      									   									  
	      									</tr> 
   							</c:forEach>
                    </tbody> 
                </table>

            </div>
		     	
	  	</div>  
	</div> 
</div> 
</body>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js|https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
        <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>
        <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/editor.bootstrap4.min.js"></script>
<script>
$(document).ready(function () {
    var table = $('#policetable').DataTable({
        lengthChange: false,
        "paging": false,
        "info": false,
        select: true
    });
    $('#healthrectable tbody').on('click', 'tr', function () {
        var selectRow = table.rows(this).data()[0];
    });
});
</script>

</html>

