<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
div.main {
	background: radial-gradient(ellipse at center, #138496 1%, #000000 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#0264d6',
		endColorstr='#1c2b5a', GradientType=1);
	height: calc(100vh);
	width: 100%;
}

[class*="fontawesome-"]:before {
	font-family: 'FontAwesome', sans-serif;
}


[class*="fontawesome-"]:before {
  font-family: 'FontAwesome', sans-serif;
}

/* ---------- GENERAL ---------- */

* {
  box-sizing: border-box;
    margin:0px auto;


}

body {
   
    color: #606468;
  font: 87.5%/1.5em 'Open Sans', sans-serif;
  margin: 0;
}

a {
	color: #eee;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

input {
	border: none;
	font-family: 'Open Sans', Arial, sans-serif;
	font-size: 18px;
	line-height: 1.5em;
	padding: 0;
	-webkit-appearance: none;
}

p {
	line-height: 1.5em;
}


.container {
  left: 50%;
  position: fixed;
  top: 50%;
  transform: translate(-50%, -50%);
}

/* ---------- LOGIN ---------- */

#login form{
	width: 350px;
}
#login, .logo{
    display:inline-block;
    width:40%;
}
#login{
border-right:1px solid #fff;
  padding: 0px 22px;
  width: 69%;
}
.logo{
color:#fff;
font-size:50px;
  line-height: 125px;
}

#login form span.fa {
	background-color: #fff;
	border-radius: 3px 0px 0px 3px;
	color: #000;
	display: block;
	float: left;
	height: 50px;
    font-size:24px;
	line-height: 50px;
	text-align: center;
	width: 50px;
}

#login form input {
	height: 50px;
}
fieldset{
    padding:0;
    border:0;
    margin: 0;

}
#login form input[type="text"], input[type="password"] {
	background-color: #fff;
	border-radius: 0px 3px 3px 0px;
	color: #000;
	margin-bottom: 1em;
	padding: 0 16px;
	width: 250px;
}

#login form input[type="submit"] {
  border-radius: 3px;
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
  background-color: #000000;
  color: #eee;
  font-weight: bold;
  /* margin-bottom: 2em; */
  text-transform: uppercase;
  padding: 5px 10px;
  height: 50px;
}

#login form input[type="submit"]:hover {
	background-color: #d44179;
}

#login > p {
	text-align: center;
}

#login > p span {
	padding-left: 5px;
	
}
.middle {
  display: flex;
  width: 600px;
}
	</style>
</head>
<body>
	<div class="main">
	<button class="btn-primary btn-lg float-right m-2">Register Now</button>
		<div class="container">
		
			<div class="middle">
				<div id="login">

					<form action="loginservlet" method="POST">

						<fieldset class="clearfix">

							<p>
								<span class="fa fa-user"></span><input type="text"
									name="username" Placeholder="Username" required>
							</p>
							<p>
								<span class="fa fa-lock"></span><input type="password"
									name="password" Placeholder="Password" required>
							</p>

							<div>
								<span
									style="width: 48%; text-align: left; display: inline-block;"><a
									class="small-text" href="#" data-target="#forgotpassword"
									data-toggle="modal">Forgot password?</a></span> <span
									style="width: 50%; text-align: right; display: inline-block;">
									
									<input type="submit" value="Sign In"></span>
							</div>

						</fieldset>
						<div class="clearfix"></div>
					</form>

					<div class="clearfix"></div>

				</div>
				
				<div class="logo ml-2">
					Login

					<div class="clearfix"></div>
				</div>

			</div>
		</div>


	</div>



	<div class="modal fade" id="forgotpassword" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document"
			style="width: 400px; height: 600px">
			<div class="modal-content">

				<div class="modal-header w3-content">
					<h5 class="modal-title w3-wide" id="exampleModalLabel">Reset
						password</h5>
					<!--                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>-->
				</div>

				<div class="modal-body">
					<form accept-charset="UTF-8" role="form" id="login-form" method="post">
						<fieldset>

							<h6>What is the question?What is the question?What is the
								question?What is the question?</h6>
							<div align="center">
								<input type="password" class="form-control" id="answerbox">
							</div>
							<br>
							<div align="right">
								<button type="button" class="btn btn-info"
									data-target="#resetpassword" data-dismiss="modal" data-toggle="modal">Recover</button>
							</div>
							<br>
							
							<div class="form-group">
					<p class="help-block">
						<a class="pull-right text-muted" href="#" id="olvidado"><small>Forgot
								your password?</small></a>
					</p>
						</div>
					</fieldset>
					</form>
				</div>


				
				</div>
				
				
				
			</div>
		</div>



	<div class="modal fade" id="resetpassword" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document"
			style="width: 400px; height: 600px">
			<div class="modal-content">

				<div class="modal-header w3-content">
					<h5 class="modal-title w3-wide" id="exampleModalLabel">Reset
						password</h5>
					<!--                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>-->
				</div>

				<div class="modal-body">
					<form accept-charset="UTF-8" role="form" id="login-form"
						method="post">
						<fieldset>
							<p align="left">Enter new password:</p>
							<div align="center">
								<input type="password" class="form-control" id="answerbox">
							</div>
							<br>
							<p align="left">Confirm new password:</p>
							<div align="center">
								<input type="password" class="form-control" id="answerbox">
							</div>
							<br>
							<div align="right">
								<button class="btn btn-info">Reset password</button>
							</div>


							<div class="form-group">
								<p class="help-block">
									<a class="pull-right text-muted" href="#" id="olvidado"><small>Reset
											your password?</small></a>
								</p>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
<script>
	$('#forgotpassword').on('shown.bs.modal', function() {
		$('#myInput').trigger('focus')
	});
	$('#resetpassword').on('shown.bs.modal', function() {
		$('#myInput').trigger('focus')
	});
</script>
</html>