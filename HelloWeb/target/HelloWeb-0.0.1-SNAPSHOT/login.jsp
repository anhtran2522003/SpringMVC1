<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>


<link type="text/css" rel="stylesheet" href="css/signup.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<!-- Slick -->
<link type="text/css" rel="stylesheet" href="css/slick.css" />
<link type="text/css" rel="stylesheet" href="css/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet" href="css/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />

<link type="text/javascript" rel="stylesheet" href="jquery.js" />



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>
<body>


	<!-- HEADER -->
	<%@ include file="header_logSign.jsp"%>
	<!-- /HEADER -->

	<div id="backgroud">
		<div class="wrapper">
			<div class="logo">
				<img src="./img/logo.png" alt="">
			</div>
			<div class="text-center mt-4 name"></div>

			<form class="p-3 mt-3" action='/HelloWeb/Login' method='post'>
				<p>${error == null ? "" : error}</p>
				<input type="hidden" name="action" value="formsubmit">
				<div class="form-field d-flex align-items-center">
					<span class="far fa-user"> </span> <input type="text"
						name="username" id="username" placeholder="Username"
						value="${user == null ?  '' : user}">

				</div>
				<div class="form-field d-flex align-items-center">
					<span class="fas fa-key"></span> <input type="password"
						name="password" id="pwd" placeholder="Password"
						value="${password == null ? ''   : password }">
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1"
						name="rememberMe"> <label class="form-check-label"
						id="rememberAccount" for="rememberAccount">Remember me </label>
				</div>
				<button class="btn mt-3">Login</button>
			</form>
			<div class="text-center fs-6">
				<a href="#">Forget password?</a> or <a href="signup.jsp">Sign up</a>
			</div>

		</div>
	</div>


	<!-- FOOTER -->
	<%@ include file="footer.jsp"%>
	<!-- /FOOTER -->

</body>