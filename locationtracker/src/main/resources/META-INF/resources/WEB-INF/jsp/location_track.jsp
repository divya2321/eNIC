<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script type='text/javascript' src='/array.generics.min.js'></script>
    <script type='text/javascript' src='/jquery.min.js'></script>
     <script type="text/JavaScript" src='/BiominiWebAgent.js'></script>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <style>
  body {
   
   	background: radial-gradient(ellipse at center, #138496 1%, #000000 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#0264d6',
		endColorstr='#1c2b5a', GradientType=1);
	height: calc(100vh);
	width: 100%;
}
  div.main {

}
  
  </style>
<title>Location Tracker</title>
</head>
<body onload="InitPage();Init();"
      onbeforeunload="DeletePage()">


	<div class="container" style="width: 60%">
	<div class="card m-2 ">
	  <div class="card-header d-flex justify-content-center">
    People tracking form
  </div>
	<div class="card-body">
		<div class="row">
<div class="col-sm-12">
	<div class="d-flex justify-content-center">
	<div>
			<form action="/org/location/track/find">
			
			<div class="form-group">
						<label for="nic">NIC number:</label> <br> 
						<input type="text" class="form-control" name="nic" value="${person.nicNo}">
					</div>
					
					<div class="row-inline ">
					<br>
					<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary">&nbsp;Find Person&nbsp;</button>
					</div>
				</div>
			</form>
			
			
			
			<c:if test="${person != null}">
			<hr/>
						<input type="text" class="form-control" value="${person.nicNo}" id="personNic" name="nic" style="display: none;">
						<input type="text" class="form-control" value="${person.fingerprint}" id="Tb_Template" name="fingerprint" style="display: none;">
						
			<div class="form-group">
						<label for="name">Name:</label> <br> 
						<input type="text" class="form-control" value="${person.name}" id="personName" name="name" readonly>
					</div>
					
						
				
					
					<div class="row">
			
						<div class="col-sm-4">
                                <label>FingerPrint Live Image</label>
                          
                            
                                <p>
                                    <img id="Fpimg" width="160" height="200" />
                                </p>
                                 
                                 </div>  
                                 
                                 <div class="col-sm-8">
                                 
                                  <textarea id="Tb_DisplayLog" style="width:320px;height:250px;" ></textarea>
                                 </div>
                        
                        
                        
                           
                            
                           </div> 
                           
					
					<br/>
					<br/>
					<div class="d-flex justify-content-center">
					<button  id="Bt_TempDataVerify" type="button" class="btn btn-success" onclick="VerifyWithTemplate();">&nbsp;Track Person&nbsp;</button>
					
					</div>
					
			
			</c:if>	
				
		
		</div>
</div>
</div>
</div>
	</div>
	</div>
</div>

<script>

</script>

</body>
</html>