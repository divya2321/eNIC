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
<title>Register users</title>

</head>

<body style="background-color: #FFFFFF">
	<div class="navbar bg-dark w3-large">

		<span class="nav-item text-light" style="font-size:20px;">Register Users</span>
		<div class="d-flex justify-content-end">
						<button class="btn btn-primary btn-lg" type="submit">Register</button>
					</div>
	</div>

	<br />
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-4">
				<form action="/Ctpeoplereg.html" id="webserveform1">
					<div class="form-group"></div>

					<div class="form-group">
						<label for="tname">NIC:</label> <input type="text"
							class="form-control" id="tname">
					</div>


					<div class="form-group">
						<label for="fname">First name:</label> <input type="text"
							class="form-control" id="fname">
					</div>

					<div class="form-group">
						<label for="lname">Last name:</label> <input type="text"
							class="form-control" id="lname">
					</div>

					<div class="form-group">
						<label for="gender">Gender:</label> <br>
						<div class="form-check-inline">
							<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="optradio">Female
							</label>
						</div>
						<div class="form-check-inline">
							<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="optradio">Male
							</label>
						</div>
					</div>

					<div class="form-check-inline">
						<div class="form-group">
							<label for="branch">Branch name:</label> <input type="text"
								class="form-control" id="branch">
						</div>
						&nbsp;&nbsp;&nbsp;
						<div class="form-group">
							<label for="designation">Designation:</label> <input type="text"
								class="form-control" id="designation">
						</div>
					</div>
					<div class="form-check-inline">
						<div class="form-group">
							<label for="uname">Username:</label> <input type="text"
								class="form-control" id="uname">
						</div>
						&nbsp;&nbsp;&nbsp;
						<div class="form-group">
							<label for="pword">Password:</label> <input type="password"
								class="form-control" id="pword">
						</div>
					</div>
					<br>
					<div class="d-flex justify-content-end">
					<button class="btn btn-primary" type="submit" form="webserveform1">Add</button>
					</div>
					<br> <br>
				</form>
			</div>
			<div class="col-sm-8">
				<div class="table-responsive">
					<table id="usertable"
						class="table table-striped table-bordered container table-hover "
						style="width: 100%;">
						<thead class="thead-light">
							<tr>
								<th>NIC</th>
								<th>First name</th>
								<th>Last name</th>
								<th>Gender</th>
								<th>Branch name</th>
								<th>Designation</th>
								<th>Username</th>
								<th>password</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>200011202938</td>
								<td>Nipun</td>
								<td>Amarakoon</td>
								<td>Male</td>
								<td>Colombo</td>
								<td>Software engineer</td>
								<td>nipun10</td>
								<td>nipunjshnacsaksvar</td>
							</tr>
							<tr>
								<td>975232760V</td>
								<td>Divya</td>
								<td>Sitinamaluwa</td>
								<td>Female</td>
								<td>Colombo</td>
								<td>Software engineer</td>
								<td>divvawf</td>
								<td>divvansa</td>
							</tr>
						</tbody>
					</table>
					
				</div>
			</div>

		</div>

	</div>
</body>

</html>

