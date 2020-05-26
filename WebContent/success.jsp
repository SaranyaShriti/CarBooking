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
<title>Success</title>
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">

				<div class="card border-primary mb-3" style="max-width: 18rem;">
					<div class="card-header">Successfully booked!</div>
					<div class="card-body text-primary">
						<h5 class="card-title">${car.carType}</h5>
						<p class="card-text">${car.seater} Seats available!</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>