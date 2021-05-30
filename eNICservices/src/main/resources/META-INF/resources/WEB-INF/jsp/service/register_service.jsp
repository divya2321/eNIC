<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<button class="btn btn-primary btn-md" type="submit" form="webserveform1">Register Now</button>
	</div>

	<br />
	<div class="container-fluid">
		<form:form action="/org/registerorg" id="webserveform1" modelAttribute="orgModel" method="POST">
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


					<spring:bind path="organizationName">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:label path="organizationName">Organization name:</form:label> 
								<form:input path="organizationName" type="text" class="form-control" id="orgname"/>
								 <form:errors path="organizationName" style="color: red;"></form:errors>
							</div>
					</spring:bind>



					<div class="form-row">
						<spring:bind path="organizationCode">
							<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:label path="organizationCode">Organization code:</form:label> 
							<form:input path="organizationCode" type="text" class="form-control" id="orgcode"/>
							 <form:errors path="organizationCode" style="color: red;"></form:errors>
						</div>
						</spring:bind>
					</div>
					
					<spring:bind path="organizationHead">
							<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="organizationHead">Organization head:</form:label> 
						<form:input path="organizationHead" type="text" class="form-control" id="orgname"/>
						 <form:errors path="organizationHead" style="color: red;"></form:errors>
					</div>
					</spring:bind>
					
					
					
			</div>
			
			<div class="col-sm-6">
				
				<div class="form-group">
					<form:label path="orgAddressNo">Organization Address</form:label><br> 
					
					<spring:bind path="orgAddressNo">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:label path="orgAddressNo">No:</form:label> 
								<form:input path="orgAddressNo" type="text" class="form-control" id="hdaddressno" form="webserveform1"/> 
								 <form:errors path="orgAddressNo" style="color: red;"></form:errors>
							</div>
					</spring:bind>
					
					
					<spring:bind path="orgAddressStreet1">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:label path="orgAddressStreet1">Street 1:</form:label> 
								<form:input path="orgAddressStreet1" type="text" class="form-control" id="hdaddressstrt1" form="webserveform1"/> 
								 <form:errors path="orgAddressStreet1" style="color: red;"></form:errors>
						</div>
						</spring:bind>
					
					<spring:bind path="orgAddressStreet2">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:label path="orgAddressStreet2">Street 2:</form:label> 
									<form:input path="orgAddressStreet2" type="text" class="form-control" id="hdaddressstrt2" form="webserveform1"/> 
									 <form:errors path="orgAddressStreet2" style="color: red;"></form:errors>
							</div>
					</spring:bind>
					
					
					<spring:bind path="orgAddressCity">
							<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:label path="orgAddressCity">City:</form:label> 
									<form:input path="orgAddressCity" type="text" class="form-control" id="hdaddrcity" form="webserveform1"/>
									 <form:errors path="orgAddressCity" style="color: red;"></form:errors>
							</div>
					</spring:bind>				
					
				</div>

				<div class="form-row">
					<spring:bind path="orgContact1">
							<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="orgContact1">Telephone Number:</form:label> 
						<form:input path="orgContact1" type="tel" class="form-control" id="hdtpno" form="webserveform1"/>
						 <form:errors path="orgContact1" style="color: red;"></form:errors>
					</div>
					</spring:bind>
					
					&nbsp;&nbsp;&nbsp;
					
					
				<spring:bind path="orgContact2">
							<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="orgContact2">Mobile Number:</form:label>
						<form:input path="orgContact2" type="tel" class="form-control" id="hdmobileno" form="webserveform1"/>
						 <form:errors path="orgContact2" style="color: red;"></form:errors>
							</div>
				</spring:bind>
					
					
				</div>

				<spring:bind path="orgEmailAddress">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:label path="orgEmailAddress">E-mail Address:</form:label> 
								<form:input path="orgEmailAddress" type="email" class="form-control" id="hdemailaddress" form="webserveform1"/>
								 <form:errors path="orgEmailAddress" style="color: red;"></form:errors>
						</div>
				
				</spring:bind>
				
				<br>


				</div>
			
		</div>
</form:form>
	</div>
</body>

</html>

