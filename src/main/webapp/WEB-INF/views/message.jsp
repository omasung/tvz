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
  <title>${pageTitle}</title>    
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
  <link rel="stylesheet" type="text/css" href="/resources/registration/style.css">
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
	<div class="form-container sign-in-container">
		<form>
			<p>${message}</p>
		</form>		
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
