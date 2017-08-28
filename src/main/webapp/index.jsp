<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=us-ascii" />


<title>reservation</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="resources/css/datepicker.css" type="text/css" />

<script src="resources/js/jquery.js" type="text/javascript"></script>
<script src="resources/js/bootstrap-datepicker.js" type="text/javascript"></script>


<script type="text/javascript">
	       
	$(function() {
		window.prettyPrint && prettyPrint();
		$('#startDate').datepicker({
			format : 'mm-dd-yyyy'
		});
	});
</script>

</head>

<body>
<div style="float:left; width:20%;">
	<a class="brand" href="/airreservation/index.jsp"><H3>AIR LINES  TRAVEL</H3></a>
    </div>
	<div style="float:right; width:40%; margin-left:10px;">
    <a href="http://localhost:9090/airreservation/managebook/viewReservation.do"><H3>View Reservation</H3></a>
   </div>	
<br/>
<br/>
<br/>
<br/>

<form  action="http://localhost:9090/airreservation/search/results.do" id="searchForm" method="post">
		<h4>Book Tickets<h4>						
							

	<p>		
             <span class="label label-info">Leaving From</span><br/>
             <select name="origin" id="origin" style="width: 160px;">
	               			<option selected value="DFW">Dallas Ft Worth (DFW)</option>
	               			<option value="NYI">New York International (NYI)</option>
	               			<option value="LHR">London Heathrow (LHR)</option>
	               			<option value="CDG">Charles De Gaulle (CDG)</option>
             </select>                        
	</p>				

	<p>
		<div class="controls">  
             <span class="label label-info">Going To</span><br/>
			 <select name="destination" id="destination" style="width: 160px;">
	               			<option value="DFW">Dallas Ft Worth (DFW)</option>
	               			<option selected value="NYI">New York International (NYI)</option>
	               			<option value="LHR">London Heathrow (LHR)</option>
	               			<option value="CDG">Charles De Gaulle (CDG)</option>
             </select>                          
           </div>           
           
	</p>	

	<p>
		<span class="label label-info">Departure Date</span><br/>
		<% Date date = new Date(); 
		SimpleDateFormat ft = new SimpleDateFormat (" MM-dd-yyyy ");%>		
			<input value=<%= ft.format(date) %>   name="startDate" id="startDate"	type="text" size="30" style="width: 160px;" />			
		<br>									
	</p>
	<p>
		<span class="label label-info">Number of Passengers</span><br/>
		
			<input name="nseats" id="numberOfPassengers"
				type="number" size="30" style="width: 160px;"  
				step="1" value="1"/>		
		</p>
		<button type="submit" class="btn" id="searchResults">Search</button>
 	</div>	
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
		</div>	
	</div>
</form>


</body>
</html>
