<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conform</title>
 <head>
    <%@ page isELIgnored="false" %>
 </head>
</head>
<body>
<h2> Successfully Booked Flight</h2>
		<br/>
<h3>Your Conformation Number:</h3>${confnbr}
		<br/>
<h3>Flight Number</h3>${flight.fnum}
		<h3>Flight Origin</h3>${flight.origin}
		<h3>Flight Destination</h3>${flight.destination}
		<h3>Flight Departure</h3>${flight.dtime}
		<h3>Flight Arrival</h3>${flight.atime}
		<h3>Number of seats booked successfully </h3>${nooftickets} 
	    
<h2>Passenger Details</h2>
		<br>
		<table border="3">
		 <tr>
		 <th>Passenger First name</th>
			<th>Passenger last name</th>
			<th>Passenger Dob</th>
			<th>Passenger email</th>
		 </tr>
			 <c:forEach items="${passengers}" var="f">
				<tr>
				<td><c:out value="${f.fname}"/></td>
				<td><c:out value="${f.lname}"/></td>
				<td><c:out value="${f.dob}"/></td>
				<td><c:out value="${f.email}"/></td>
				</tr>
			  </c:forEach>
		 </table>
		 <p/>
		 
				<h4>Total Amount</h4><c:out value="${amount}"/> Paid
				<p/>
<a href="http://localhost:9090/airreservation/index.jsp">Want to Book flight!! Again</a>


		
</body>
</html>