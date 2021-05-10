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
<title>Register contact people</title>

</head>

<body style="background-color: #FFFFFF">
	<div class="navbar bg-dark w3-large">

		<span class="nav-item text-light" style="font-size:20px;">Register Contact People</span>
		<button class="btn btn-primary btn-lg" type="submit" form="webserveform1">Next&#62;&#62;</button>
	</div>

	<br />
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-4 border-right" >
				<form action="/Ctpeoplereg.html" id="webserveform1">
					<div class="form-group">
						<h4>Technical Matters</h4>

					</div>

					<div class="form-group">
						<label for="tname">Name:</label> <input type="text"
							class="form-control" id="tname">
					</div>


					<div class="form-group">
						<label for="permanentaddress">Address</label><br> <label
							for="taddressno">No:</label> <input type="text"
							class="form-control" id="taddressno"> <label
							for="taddressstreet1">Street 1:</label> <input type="text"
							class="form-control" id="taddressstreet1"> <label
							for="taddressstreet2">Street 2:</label> <input type="text"
							class="form-control" id="taddressstreet2"> <label
							for="tcity">City:</label> <input type="text" class="form-control"
							id="tcity">
					</div>

					<div class="form-row">
						<div class="form-group">
							<label for="ttpno">Telephone Number:</label> <input type="tel"
								class="form-control" id="ttpno">
						</div>
						&nbsp;&nbsp;&nbsp;
						<div class="form-group">
							<label for="tmbno">Mobile Number:</label> <input type="tel"
								class="form-control" id="tmbno">
						</div>
					</div>
					<div class="form-group">
						<label for="temail">E-mail Address:</label> <input type="email"
							class="form-control" id="temail">
					</div>
				</form>
			</div>
			<div class="clearfix"></div>
			<div class="col-sm-4 border-right">
				<div class="form-group">
					<h4>Legal Matters</h4>

				</div>

				<div class="form-group">
					<label for="lname">Name:</label> <input type="text"
						class="form-control" id="lname" form="webserveform1">
				</div>


				<div class="form-group">
					<label for="permanentaddress">Address</label><br> <label
						for="laddressno">No:</label> <input type="text"
						class="form-control" id="laddressno" form="webserveform1">
					<label for="laddressstreet1">Street 1:</label> <input type="text"
						class="form-control" id="laddressstreet1" form="webserveform1">
					<label for="laddressstreet2">Street 2:</label> <input type="text"
						class="form-control" id="laddressstreet2" form="webserveform1">
					<label for="lcity">City:</label> <input type="text"
						class="form-control" id="lcity" form="webserveform1">
				</div>

				<div class="form-row">
					<div class="form-group">
						<label for="ltpno">Telephone Number:</label> <input type="tel"
							class="form-control" id="ltpno" form="webserveform1">
					</div>
					&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label for="lmbno">Mobile Number:</label> <input type="tel"
							class="form-control" id="lmbno" form="webserveform1">
					</div>
				</div>
				<div class="form-group">
					<label for="lemail">E-mail Address:</label> <input type="email"
						class="form-control" id="lemail" form="webserveform1">
				</div>

			</div>
			<div class="col-sm-4 border-right">
				<div class="form-group">
					<h4>Financial Matters</h4>

				</div>

				<div class="form-group">
					<label for="fname">Name:</label> <input type="text"
						class="form-control" id="fname" form="webserveform1">
				</div>


				<div class="form-group">
					<label for="permanentaddress">Address</label><br> <label
						for="faddressno">No:</label> <input type="text"
						class="form-control" id="faddressno" form="webserveform1">
					<label for="faddressstreet1">Street 1:</label> <input type="text"
						class="form-control" id="faddressstreet1" form="webserveform1">
					<label for="faddressstreet2">Street 2:</label> <input type="text"
						class="form-control" id="faddressstreet2">
					form="webserveform1" <label for="fcity">City:</label> <input
						type="text" class="form-control" id="fcity" form="webserveform1">
				</div>

				<div class="form-row">
					<div class="form-group">
						<label for="ftpno">Telephone Number:</label> <input type="tel"
							class="form-control" id="ftpno" form="webserveform1">
					</div>
					&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label for="fmbno">Mobile Number:</label> <input type="tel"
							class="form-control" id="fmbno" form="webserveform1">
					</div>
				</div>
				<div class="form-group">
					<label for="femail">E-mail Address:</label> <input type="email"
						class="form-control" id="femail" form="webserveform1">
				</div>
			</div>


		</div>

	</div>
</body>

</html>

