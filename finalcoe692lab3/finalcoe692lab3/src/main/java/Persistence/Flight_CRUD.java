package Persistence;

import Helper.flightBooked;
import java.sql.*;
import java.util.*;

/**
 *
 * @author student
 */


public class Flight_CRUD {
    private static Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight?&serverTimezone=UTC","root","student");
            System.out.println("Connection established.");
	}
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
//    public static ArrayList<flightBooked> read (String username) {
//        ArrayList<flightBooked> bean = null;
//        try {
//            Connection con = getCon();
//            String q = "SELECT * FROM passengerInfo WHERE username LIKE " + '"' + username + '"';
//            bean = new ArrayList<>();
//            PreparedStatement ps = con.prepareStatement(q);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String flightName = rs.getString("account_number");        
//                String flight = rs.getString("balance");
//                Date flightDate = rs.getDate("card_number");
//                boolean available = rs.getBoolean("account_type");
//                bean.add(new flightBooked(flightName, flight, flightDate, available));
//            }
//            con.close();
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }       
//        return bean;
//    }
    
    public static void create(String firstName, String lastName, String email, String phoneNumber, String numPassengers, String cardNumber) {
    try {
        Connection con = getCon();
        Statement stmt = con.createStatement();
        String values = "'" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNumber + "', '" + numPassengers + "', '" + cardNumber + "' ";
       String q = "INSERT INTO bookFlight(firstName, lastName, email, phoneNumber, numPassengers, cardNumber) VALUES (" + values + ");";
        System.out.println(q); 
       stmt.execute(q);
        System.out.println("Inserted");
        con.close();
    } catch(Exception e) {
        System.out.println(e);
    }
}}
