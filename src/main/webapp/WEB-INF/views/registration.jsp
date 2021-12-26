<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Registration</title>    
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
  <link rel="stylesheet" type="text/css" href="/resources/registration/style.css">
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
	<div class="form-container sign-in-container">
		<form:form method="POST" modelAttribute="users" action="/registration/form" name="users">
			<h2>Create An Account</h2>
			<span id="userMessage" style="color: orange; margin-bottom: 10px;">complete the registration form</span>
			<span id="userMessage" style="color: red; margin-bottom: 10px;">${message}</span>
			<form:input type="text" path="name" id="name" placeholder="Name"/>
			<form:input type="text" path="username" id="username" placeholder="Username"/>
			<form:input type="email" path="email" id="email" placeholder="Email"/>
			<form:input type="password" path="password" id="password" placeholder="Password"/>
			<div style="margin-bottom: 20px;"></div>
			<button type="submit" onclick="return validate();">Sign Up</button>
		</form:form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-right">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Login</button>
			</div>
		</div>
	</div>
</div>

<footer>
	<p>
		@TVZ <i class="fa fa-heart"></i> by Sunday Omada.
	</p>
</footer>
<!-- partial -->
<script  src="/resources/registration/script.js"></script>
<script  src="/resources/registration/validateReg.js"></script>

</body>
</html>
