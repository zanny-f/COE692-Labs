<%-- 
    Document   : userbooks
    Created on : Jan 24, 2021, 1:00:48 AM
    Author     : student
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Helper.flightBooked"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Flight</title>
    </head>
    <style>

body {
  background-color: #E6E6FA;

}
</style>
<% 
    ArrayList<flightBooked> bookedFlight= (ArrayList)request.getAttribute("flightBookedInfo");
  
%>

<center><h2>Hello <%=session.getAttribute("uname")%></h2></center>
<br>
<center><h3> The following Flights are available.</h3></center>
<br>
<form action="flightBooking" method="post">
<table border="2" align="center" cellpadding="5" cellspacing="5">

<tr>
   
<th> Name </th>
<th> Flight </th>
<th> Flight Date </th>
<th> Book </th>

</tr>

    <% for(flightBooked flight: bookedFlight){
    %>
<tr>
<td> <%=flight.getflightName()%> </td>
<td> <%=flight.getflight()%></td>
<td> <%=new SimpleDateFormat("yyyy-MM-dd").format(flight.getflightDate())%></td>
<% if (flight.isAvailable()){
%>
<td> <input type="submit" value="Book Flight" ></td>
<%}

else {
%>


<td> "The Flight is not available for booking"</td>
<% }}
%>
</tr>
</table>
</form>
</body>
</html>
