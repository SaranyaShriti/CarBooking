<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<h4 class="mx-auto" style="width: 180px;">LOGIN FORM</h4>

				<form action="loginServlet" method="post">
					<div class="form-group">
						User Name <input type="text" class="form-control" name="username"
							required />
					</div>
					<div class="form-group">
						Password <input type="password" class="form-control"
							name="password" required />
					</div>
					<div class="form-group">
						<input class="btn btn-primary btn-block" type="submit" value="Login" />
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>