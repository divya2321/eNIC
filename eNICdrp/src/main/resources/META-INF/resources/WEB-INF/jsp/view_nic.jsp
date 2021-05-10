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
  
<title>All NICs</title>

</head>

<body style="background-color: #FFFFFF">
	<div class="navbar bg-dark w3-large">

		<span class="nav-item text-light"  style="font-size:20px;">Department for Registration of Persons</span>
	</div>

	<br />
	<div class="container-fluid m-4">
		<div class="row">

				<div class="table-responsive">
				
					<table id="nictable"
						class="table table-striped table-bordered table-hover "
						style="width: 100%;">
						
						<thead class="thead-light">
							<tr>
								<th>ID</th>
								<th>NIC</th>
								<th>Name</th>
								<th>Gender</th>
								<th>DoB</th>
								<th>Applied date</th>
								<th>Registered date</th>
								<th>Type</th>
								<th>View users</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>01</td>
								<td>975232760V</td>
								<td>Divya Nimsara Sandadevini Sitinamaluwa</td>
								<td>Female</td>
								<td>23/01/1997</td>
								<td>18/04/2021</td>
								<td>06/05/2021</td>
								<td>New</td>
								<td><a href="#">View more</a></td>
							</tr>
							
							<tr>
								<td>02</td>
								<td>200011202938</td>
								<td>Nipun Jayasanka Amarakoon</td>
								<td>Male</td>
								<td>21/04/2000</td>
								<td>16/04/2021</td>
								<td>15/05/2021</td>
								<td>Renew</td>
								<td><a href="#">View more</a></td>
							</tr>
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