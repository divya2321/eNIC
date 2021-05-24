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

			<form action="/finance/fill/form/process">
				<br> <span>Person one:</span> <br>
			
					<div class="form-group">
						<label for="nic">NIC number:</label> <br> <input type="text"
							class="form-control" name="nic1">
					</div>
				<br> <span>Person two:</span> <br>
					<div class="form-group">
						<label for="nic">NIC number:</label> <br> <input type="text"
							class="form-control" name="nic2">
					</div>
				
				<div class="row-inline ">
					<br>
					<button type="submit" class="btn btn-primary">&nbsp;Fill Form&nbsp;</button>
				</div>
			</form>
		</div>



	</div>
</body>

</html>

