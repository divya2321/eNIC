<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	<a href="/org/registration" class="btn-primary btn-lg float-right m-2">Register Now</a>
		<div class="container">
		
			<div class="middle">
				<div id="login">

					  <form action="/org/login" method="POST" class="form-signin" autocomplete="off">

          <fieldset class="clearfix">
			<div class="form-group ${error != null ? 'has-error' : ''}">
			
            <p ><span class="fa fa-user"></span><input name="username" type="text"  Placeholder="Username" /></p> <!-- JS because of IE support; better: placeholder="Username" -->
            <p><span class="fa fa-lock"></span><input name="password" type="password"  Placeholder="Password" /></p> <!-- JS because of IE support; better: placeholder="Password" -->
            <b style="color: red;">${error}</b>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
             <div style="margin-left: 50px">
                              
                                <span style="width:50%; text-align:right;  display: inline-block;"><input type="submit" value="Login"></span>
                            </div>
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






	

</body>

</html>