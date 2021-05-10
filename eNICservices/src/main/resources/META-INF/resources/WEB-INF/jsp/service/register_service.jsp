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
<title>Register service</title>

</head>

<body>
	<div class="navbar bg-dark w3-large">

		<span class="nav-item text-light ">Register Service</span>
		<button class="btn btn-primary btn-lg" type="submit" form="webserveform1">Next&#62;&#62;</button>
	</div>

	<br />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-6 ">
				<form action="#" id="webserveform1">
					<div class="form-group">
						<label for="orgtype">Organization type:</label> 
							<button class="btn btn-secondary dropdown-toggle" 
								type="button" id="dropdownMenuButton" 
								data-toggle="dropdown" 
								aria-haspopup="true" 
								aria-expanded="false">
	    							Select a type
  							</button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							    <a class="dropdown-item" href="#">Financial Institution</a>
							    <a class="dropdown-item" href="#">Criminal Service</a>
							    <a class="dropdown-item" href="#">Healthcare Service</a>
							    <a class="dropdown-item" href="#">Police Service</a>
							    <a class="dropdown-item" href="#">Judicial Service</a>
							  </div>
					</div>

					<div class="form-group">
						<label for="orgname">Organization name:</label> 
						<input type="text" class="form-control" id="orgname">
					</div>

					<div class="form-row">
						<div class="form-group">
							<label for="orgcode">Organization code:</label> 
							<input type="text" class="form-control" id="orgcode">
						</div>
					</div>


					<div class="form-group">
						<label for="permanentaddress">Permanent Address</label><br> 
						<label for="permanentaddress">No:</label> 
						<input type="text" class="form-control" id="fullname"> 
						<label for="permanentaddress">Street 1:</label> 
						<input type="text" class="form-control" id="fullname"> 
						<label for="permanentaddress">Street 2:</label> 
						<input type="text" class="form-control" id="fullname"> 
						<label for="permanentaddress">City:</label> 
						<input type="text" class="form-control" id="fullname">
					</div>

					<div class="form-row">
						<div class="form-group">
							<label for="tpno">Telephone Number:</label> 
							<input type="tel" class="form-control" id="tpno">
						</div>
						&nbsp;&nbsp;&nbsp;
						<div class="form-group">
							<label for="mobileno">Mobile Number:</label> 
							<input type="tel" class="form-control" id="mobileno">
						</div>
					</div>
					<div class="form-group">
						<label for="emailaddress">E-mail Address:</label> 
						<input type="email" class="form-control" id="emailaddress">
					</div>
					</form>
			</div>
			
			<div class="col-sm-6">
				<div class="form-group">
					<label for="orghdname">Organization head name:</label> 
					<input type="text" class="form-control" id="orghdname" form="webserveform1">
				</div>
				<div class="form-group">
					<label for="orghddes">Organization head designation:</label> 
					<input type="text" class="form-control" id="orghddes" form="webserveform1">
				</div>
				<div class="form-group">
					<label for="permanentaddress">Permanent Address</label><br> 
					<label for="hdaddressno">No:</label> 
					<input type="text" class="form-control" id="hdaddressno" form="webserveform1"> 
					<label for="hdaddressstrt1">Street 1:</label> 
					<input type="text" class="form-control" id="hdaddressstrt1" form="webserveform1"> 
					<label for="hdaddressstrt2">Street 2:</label> 
					<input type="text" class="form-control" id="hdaddressstrt2" form="webserveform1"> 
					<label for="hdaddrcity">City:</label> 
					<input type="text" class="form-control" id="hdaddrcity" form="webserveform1">
				</div>

				<div class="form-row">
					<div class="form-group">
						<label for="hdtpno">Telephone Number:</label> 
						<input type="tel" class="form-control" id="hdtpno" form="webserveform1">
					</div>
					&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label for="hdmobileno">Mobile Number:</label>
						<input type="tel" class="form-control" id="hdmobileno" form="webserveform1">
					</div>
				</div>

				<div class="form-group">
					<label for="hdemailaddress">E-mail Address:</label> 
					<input type="email" class="form-control" id="hdemailaddress" form="webserveform1">
				</div>
				
				<br>


			</div>
		</div>

	</div>
</body>

</html>

