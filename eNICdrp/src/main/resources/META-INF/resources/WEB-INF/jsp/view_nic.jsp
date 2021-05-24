<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap4.min.css"/>
  
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
  
<title>All NICs</title>

</head>

<body style="background-color: #FFFFFF">
	<div class="navbar bg-dark w3-large">
		<span class="nav-item text-light"  style="font-size:20px;">Department for Registration of Persons</span>
	</div>

	<br />
	
	<div  class="ml-3">
	
	<div class="input-group">
		
			<form action="/drp/view/nic" method="GET">
			<div class="form-check-inline">
			
				<label class="form-label">NIC number:</label> 
				&nbsp; 
				<input id="search-focus" name="nic" type="text"  class="form-control" />
			
			&nbsp; &nbsp;
			<button type="submit" class="btn btn-primary"  >
				<i class="fas fa-search"></i>
			</button>
			</div>
			</form>
			</div>
			</div> 
			 
	<div class="container-fluid m-4">
		<div class="row">

				<div class="table-responsive">
				
					<table id="nictable"
						class="table table-striped table-bordered table-hover "
						style="width: 100%;">
						
						<thead class="thead-light">
							<tr>
								<th>Application no</th>
								<th>Application type</th>
								<th>NIC</th>
								<th>Name</th>
								<th>Gender</th>
								<th>DoB</th>
								<th>Applied date</th>
								<th>Registered date</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${drpEntities}" var="drpEntity">
                                     
	                                     	<tr>
	      									  <td> ${drpEntity.applicationNo} </td>
	      									   <td>	${drpEntity.applicationType}</td>
	      									  <td> ${drpEntity.nicNo} </td>
	      									  <td> ${drpEntity.name} </td>
	      									  <td> ${drpEntity.gender} </td>
	      									  <td> ${drpEntity.dob}</td>
	      									  <td>	${drpEntity.recievedDate}</td>
	      									  <td>	${drpEntity.registeredDate}</td>
	      								
												
	      							
	      									   									  
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
                            var table = $('#nictable').DataTable({
                                lengthChange: false,
                                "paging": false,
                                select: true
                            });
                            $('#nictable tbody').on('click', 'tr', function () {
                                var selectRow = table.rows(this).data()[0];
                            });
                        });
                        
                      
                     
            </script>
            
</html>