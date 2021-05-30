<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html >


<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap4.min.css"/>	
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Requested services</title>

</head>

<body style="background-color: #FFFFFF">
	<div class="navbar bg-dark w3-large">

		<span class="nav-item text-light "style="font-size:20px;">Department for Registration of Persons</span>
	</div>

	<br />
	<div class="container-fluid">
		<div class="row">

				<div class="table-responsive">
				
					<table id="orgtable"
						class="table table-striped table-bordered table-hover "
						style="width: 100%;">
						
						<thead class="thead-light">
							<tr>
								<th>Type</th>
								<th>Organization</th>
								<th>Code</th>
								<th>Head</th>
								<th>Address</th>
								<th>Contact</th>
								<th>Email</th>
								<th>Requested</th>
								<th>Status</th>
							</tr>
						</thead>

						<tbody>
						
							<c:forEach items="${allServices}" var="serviceOrg">
                                     
	                                     	<tr>
	      									  <td> ${serviceOrg.organizationType} </td>
	      									  <td> ${serviceOrg.organizationName} </td>
	      									  <td> ${serviceOrg.organizationCode} </td>
	      									  <td> ${serviceOrg.organizationHeadName} </td>
	      									  <td> ${serviceOrg.idOrgContact.orgAddressNo}, 
	      									  		${serviceOrg.idOrgContact.orgAddressStreet1},
	      									  		${serviceOrg.idOrgContact.orgAddressStreet2},
	      									  		${serviceOrg.idOrgContact.orgAddressCity}
	      									  </td>
	      									  <td> ${serviceOrg.idOrgContact.orgContact1} - 
	      									  		${serviceOrg.idOrgContact.orgContact2}
	      									  </td>
	      									  <td> ${serviceOrg.idOrgContact.orgEmailAddress} </td>
	      									  <td> ${serviceOrg.organizationRequestedDate} </td>
	      									  
	      									  <c:choose>
												  <c:when test="${serviceOrg.organizationStatus=='Pending'}">
												    <td>
			      									  <a href="/drp/services/view/update?oid=${serviceOrg.idOrganization}&ostatus=Approved" role="button" class="btn btn-success">Approve</a>
			      									  
			      									  <a href="/drp/services/view/update?oid=${serviceOrg.idOrganization}&ostatus=Rejected" role="button" class="btn btn-danger">Reject</a>			      									  
		      									  	</td>  
												  </c:when>
												  <c:otherwise>
												    <td> ${serviceOrg.organizationStatus} </td>
												  </c:otherwise>
											 </c:choose>
	      									  
	      							
	      									   									  
	      									</tr> 
   							</c:forEach>
							
						</tbody>
					</table>

					
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
    var table = $('#orgtable').DataTable({
        lengthChange: false,
        "paging": false,
    });
    

});</script>

</html>

