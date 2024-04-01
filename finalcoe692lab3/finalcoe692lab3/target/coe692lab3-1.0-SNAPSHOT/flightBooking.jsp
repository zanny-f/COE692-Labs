<%-- 
    Document   : flightBooking
    Created on : Feb 14, 2023, 2:21:23 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Booking Page</title>
    </head>
    <style>
        body{
            background-color: lightgreen;
        }
        </style>
    <body>
    <form action="confirmBooking" method="post">
        <center>
            
            <table>
                <tr>
                    <th>
                        <label for = "firstName">First Name</label>
                    </th>
                    
                    <th>
                        <input type="text" placeholder="First Name" name = "firstName" id="firstName">
                    </th>
                </tr>
                
                <tr>
                    <th>
                        <label for = "lastName">Last Name</label>
                    </th>
                    <th>
                        <input type="text" placeholder="Last Name" name = "lastName" id="lastName">
                    </th>
                </tr>
                
                <tr>
                    <th>
                        <label for = "email">Email</label>
                    </th>
                    
                    <th>
                        <input type="text" placeholder="Email" name = "email" id="email">
                    </th>
                </tr>
                
                <tr>
                    <th>
                        <label for = "phoneNumber">Phone  Number</label>
                    </th>
                    
                    <th>
                        <input type="tel" placeholder="Phone NUmber" name = "phoneNumber" id="phoneNumber">
                    </th>
                </tr>
                
                <tr>
                    <th>
                        <label for = "numberOfPassengers">Number Of Passengers</label>
                    </th>
                    
                    <th>
                        <input type="text" placeholder="Number Of Passengers" name = "numPassengers" id="numPassengers">
                    </th>
                </tr>
                
                <tr>
                    <th>
                        <label for = "cardNumber">Card Number</label>
                    </th>
                    
                    <th>
                        <input type="text" placeholder="Card Number" name = "cardNumber" id="cardNumber">
                    </th>
                </tr>

            </table>
            <input type="submit" value="Book Flight" action = "confirmBooking">
        </center>
    </form>  
    </body>
</html>
