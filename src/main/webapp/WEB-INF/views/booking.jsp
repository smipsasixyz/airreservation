<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
 <head>
    <%@ page isELIgnored="false" %>    
 </head>
<body>
<h2> Insert Passenger Info</h2>
   <form action="savepassengers.do"  method="post" >
   <table border="3">
		 <tr>
			<th>Passenger First Name</th>
			<th>Passenger Last Name</th>
			<th>Date of Birth</th>
			<th>Email</th>
			</tr>
			 <c:forEach  var="i" begin = "1" end = "${nseats}">
				<tr>
				<td><input type="text" name="fname${i}" id="fname" placeholder="Your FirstName" required="required" /></td>
				
				<td><input type="text" name="lname${i}" id="lname" placeholder="Your LastName" required="required" /></td>
				
				<td><input type="date"  name="dob${i}" id="dob" placeholder="MM-DD-YYYY" required="required" /></td>
				
				<td><input type="email" name="email${i}" id="email" placeholder="Your Email" required="required" /></td>
				
				</tr>
				</c:forEach>
				</table>
				<button type="submit" class="btn">Save</button>
				</form>
</body>
</html>
