<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<h2>Reservation Details</h2>
<pre>
Passenger name:${reservation.getPassenger().firstName}<br>
Passenger Email:${reservation.getPassenger().email}<br>
Passenger Phone No:${reservation.getPassenger().phone}<br>
Operating Airlines:${reservation.getFlight().operatingAirlines}<br>
Flight Number:${reservation.getFlight().flightNumber}<br>
Departure City:${reservation.getFlight().departureCity}<br>
Arrival City:${reservation.getFlight().arrivalCity}<br>
Date Of Departure:${reservation.getFlight().dateOfDeparture}<br>
</pre>
<h2>Update No. of Bags & Status</h2>
<form action="proceedToCheckin" method="post">
<table>
	<tr>
	<td>Reservation Id</td>
	<td><input type="text" name="id" value="${reservation.getId()}"></td>
	</tr>
	
	<tr>
	<td>No of Bags</td>
	<td><input type="text" name="numberOfBags"></td>
	</tr>

	<tr>
	<td><input type="submit" value="proceed"></td>
	</tr>

</table>
</form>
</body>
</html>