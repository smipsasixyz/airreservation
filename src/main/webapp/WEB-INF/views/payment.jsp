<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Make a Payment </h2>
${sorry}
   <form action="http://localhost:9090/airreservation/payment/processpayment.do"  method="post" >
				<p>
				Credit Card Number:
				<input type="text" name="creditnumber" id="creditnumber" required="required" />
				</p>
				<p>
				CVV:
				<input type="text" name="cvv" id="cvv"  required="required" />
				</p>
				<p>
				Total Amount: <h4>${amount} $</h4>
				<button type="submit" class="btn">Place Order</button>
				</form>
</body>
</html>