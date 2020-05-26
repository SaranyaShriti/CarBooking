<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>List of Cars</title>
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Car type</th>
							<th scope="col">Car Number</th>
							<th scope="col">Seater</th>
							<th scope="col">Action</th>
							
						</tr>
					</thead>
					<c:forEach items="${listOfcars}" var="car">
					<tr>
							<td>${car.carType}</td>
							<td>${car.carNumber}</td>
							<td>${car.seater}</td>
							
							<td><a href="bookServlet?carId=${car.carId}">Book</a><br>
							</td>
						</tr>
						
					</c:forEach>
				</table>
			</div>
			<div class="col-2"></div>

		</div>
	</div>
</body>
</html>