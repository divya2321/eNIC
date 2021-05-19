<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<button class="btn btn-primary btn-md" type="submit" form="webserveform1">Register Now</button>
	</div>

	<br />
	<div class="container-fluid">
		<form:form action="/drp/org/registerorg" id="webserveform1" modelAttribute="orgModel" method="POST">
			<div class="row">			
				<div class="col-sm-6 ">
				
					<div class="form-group">
						<form:label path="organizationType">Organization type:</form:label> 
							<form:select path="organizationType" class="form-control browser-default custom-select" >
                                    <option value="Financial">Financial Institution</option>
                                    <option value="Healthcare">Health care Service</option>
                                    <option value="Police">Police Service</option>
                                    <option value="Judicial">Judicial Service</option>
                       		</form:select>
					</div>

					<div class="form-group">
						<form:label path="organizationName">Organization name:</form:label> 
						<form:input path="organizationName" type="text" class="form-control" id="orgname"/>
					</div>

					<div class="form-row">
						<div class="form-group">
							<form:label path="organizationCode">Organization code:</form:label> 
							<form:input path="organizationCode" type="text" class="form-control" id="orgcode"/>
						</div>
					</div>
					
					<div class="form-group">
						<form:label path="organizationHead">Organization head:</form:label> 
						<form:input path="organizationHead" type="text" class="form-control" id="orgname"/>
					</div>
					
					
					
			</div>
			
			<div class="col-sm-6">
				
				<div class="form-group">
					<form:label path="orgAddressNo">Organization Address</form:label><br> 
					<form:label path="orgAddressNo">No:</form:label> 
					<form:input path="orgAddressNo" type="text" class="form-control" id="hdaddressno" form="webserveform1"/> 
					<form:label path="orgAddressStreet1">Street 1:</form:label> 
					<form:input path="orgAddressStreet1" type="text" class="form-control" id="hdaddressstrt1" form="webserveform1"/> 
					<form:label path="orgAddressStreet2">Street 2:</form:label> 
					<form:input path="orgAddressStreet2" type="text" class="form-control" id="hdaddressstrt2" form="webserveform1"/> 
					<form:label path="orgAddressCity">City:</form:label> 
					<form:input path="orgAddressCity" type="text" class="form-control" id="hdaddrcity" form="webserveform1"/>
				</div>

				<div class="form-row">
					<div class="form-group">
						<form:label path="orgContact1">Telephone Number:</form:label> 
						<form:input path="orgContact1" type="tel" class="form-control" id="hdtpno" form="webserveform1"/>
					</div>
					&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<form:label path="orgContact2">Mobile Number:</form:label>
						<form:input path="orgContact2" type="tel" class="form-control" id="hdmobileno" form="webserveform1"/>
					</div>
				</div>

				<div class="form-group">
					<form:label path="orgEmailAddress">E-mail Address:</form:label> 
					<form:input path="orgEmailAddress" type="email" class="form-control" id="hdemailaddress" form="webserveform1"/>
				</div>
				
				<br>


				</div>
			
		</div>
</form:form>
	</div>
</body>

</html>

