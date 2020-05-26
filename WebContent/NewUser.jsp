<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<title>Registration page</title>
</head>
<style>
.center {
  margin: 0;
  position: absolute;
  left: 50%;
}</style>
<body>
	<div class="container-fluid">
	
		<div class="row">
		<div class="col-4"></div>
		<div class="col-4">
			<h4 class="mx-auto" style="width: 280px;">REGISTRATION FORM</h4>
			
			<form action="userServlet" method="post">
					<div class="form-group">User Name
						<input type="text" class="form-control" name="username" required />
					</div>
					<div class="form-group">Password
						<input type="password" class="form-control" name="password" required />
					</div>
					<div class="form-group">
						Email
						<input type="email" class="form-control" name="email" required />
					</div>
					<div class="form-group">Mobile
						<input type="text" class="form-control" name="mobile" required />
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-block " value="Register" />
						
					</div>
			</form>

			</div>
			<div class="col-3">		<a href="login.jsp" class="float-right btn btn-primary" >Login</a>
			</div>
		</div>
	</div>
</body>
</html>