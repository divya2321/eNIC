<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >


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
				
					<table id="usertable"
						class="table table-striped table-bordered table-hover "
						style="width: 100%;">
						
						<thead class="thead-light">
							<tr>
								<th>Type</th>
								<th>Organization name</th>
								<th>Code</th>
								<th>Username</th>
								<th>Status</th>
								<th>Requested date</th>
								<th>Accept/Reject</th>
								<th>View more</th>
								<th>View users</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>Police</td>
								<td>Sri Lanka Police-Biyagama</td>
								<td>CD=0012124</td>
								<td>SLPBiyagama123</td>
								<td>Pending</td>
								<td>18/04/2021</td>
								<td><button class="btn-success">Accepted</button><button class="btn-danger">Reject</button></td>
								<td><a href="#">View more</a></td>
								<td><a href="#">View users</a></td>
							</tr>
							
							<tr>
								<td>Judicial</td>
								<td>Sri Lanka Main Court</td>
								<td>CD/0012P-124</td>
								<td>SLCT2121</td>
								<td>Pending</td>
								<td>16/04/2021</td>
								<td><button class="btn-success">Accepted</button><button class="btn-danger">Reject</button></td>
								<td><a href="#">View more</a></td>
								<td><a href="#">View users</a></td>
							</tr>
						</tbody>
					</table>

					
				</div>

		</div>

	</div>
</body>

</html>

