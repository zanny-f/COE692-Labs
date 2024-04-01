<%-- 
    Document   : register
    Created on : Feb 14, 2023, 2:21:23 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body style="background-color: lightblue;">
    <form action="confirmRegistration" method="post">
        <center>
            <table>
                <tr>
                    <th>
                        <label for = "name">Name</label>
                    </th>
                    
                    <td>
                        <input type="text" placeholder="Name" name ="fullName">
                    </td>
                </tr>
                
                <tr>
                    <th>
                        <label for = "username">Username</label>
                    </th>
                    
                    <td>
                        <input type="text" placeholder="Username" name ="username">
                    </td>
                </tr>
                
                <tr>
                    <th>
                        <label for = "email">Email</label>
                    </th>
                    
                    <td>
                        <input type="text" placeholder="Email" name = "email">
                    </td>
                </tr>
                
                <tr>
                    <th>
                        <label for = "phoneNumber">Phone  Number</label>
                    </th>
                    
                    <th>
                        <input type="tel" placeholder="Phone Number" name = "phoneNumber" id="phoneNumber">
                    </th>
                </tr>
                
                <tr>
                    <th>
                        <label for = "password">password</label>
                    </th>
                    
                    <th>
                        <input type="password" placeholder="Password" name = "password" id="password">
                    </th>
                </tr>
                
                <tr>
                
                </tr>
            </table>
            <center>
                    <td><input type="submit" action="registrationConfirmation" value="Register"></td>
            </center>
            <p></p>
            <p></p>
            <p></p>
    </form>

            <center>
                <form action="index.html" method="post">
                    <input type="submit" value="Back to Login" >
                </form>
            </center>
        </center>
    </body>
</html>
