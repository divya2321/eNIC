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
<title>Financial Institution</title>

</head>

<body style="background-color: #F1F1F1">
	<div class="navbar bg-dark w3-large">

		<span class="nav-item text-light ">Financial Institution</span>
	</div>



	<div class="container">
		<div class="row">

			<form action="#">
				<br> <span>Person one:</span> <br>
				<div class="form-row">
					<div class="form-group">
						<label for="nic">NIC number:</label> <br> <input type="text"
							class="form-control" id="nic">
					</div>
					&nbsp;&nbsp;&nbsp; <span class="pt-5"> OR</span> &nbsp;&nbsp;&nbsp;

					<div class="form-group">
						<label for="fringerprint">Fingerprint:</label> <br> <input
							type="text" class="form-control" id="fringerprint">
					</div>
				</div>

				<span>Person two:</span> <br>
				<div class="form-row">
					<div class="form-group">
						<label for="nic">NIC number:</label> <br> <input type="text"
							class="form-control" id="nic">
					</div>
					&nbsp;&nbsp;&nbsp; <span class="pt-5"> OR</span> &nbsp;&nbsp;&nbsp;


					<div class="form-group">
						<label for="fringerprint">Fingerprint:</label> <br> <input
							type="text" class="form-control" id="fringerprint">
					</div>
				</div>

				<div class="row-inline ">
					<br>
					<button type="submit" class="btn btn-primary">&nbsp;Search&nbsp;</button>
				</div>
			</form>
		</div>



	</div>
</body>

</html>

