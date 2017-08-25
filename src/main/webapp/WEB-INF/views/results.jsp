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
</head>
<body>
<h2> Display Flight Details</h2>
		<br>
		<form  action="passengerinfo.do"  method="post">
		<fieldset id="group1">
		<table border="3">
		 <tr>
		    <th>Select</th>
			<th>Flight  Number</th>
			<th>Origin</th>
			<th>Destination</th>
			<th>Departure</th>
			<th>Arrival</th>
			<th>Price</th>
			</tr>
			 <c:forEach items="${flights}" var="f">
				<tr>
				<td><input type="radio" name="fid" value=${f.fid} /> </td>
				<td><c:out value="${f.fnum}"/></td>
				<td><c:out value="${f.origin}"/></td>
				<td><c:out value="${f.destination}"/></td>
				<td><c:out value="${f.dtime}"/></td	>
				<td><c:out value="${f.atime}"/></td>
				<td><c:out value="${f.price}"></c:out></td>
				</tr>
				</c:forEach>
				</table>
				</fieldset>
				<button type="submit" class="btn" >Book</button>
				</form>
				</body>
</html>