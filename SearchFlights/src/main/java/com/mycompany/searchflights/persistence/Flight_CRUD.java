/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.searchflights.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import com.mycompany.searchflights.helper.Airline;
import com.mycompany.searchflights.helper.Flight;

/**
 *
 * @airline student
 */
public class Flight_CRUD {
    
    private static Connection getCon(){
    Connection con=null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
         
         
//         CHANGE THIS
                 
                 
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/search_flight?autoReconnect=true&useSSL=false", "root", "student");
         System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
    }
    
    public static Set<Flight> searchForFlights(String query){
        Set<Flight> flights= new HashSet<Flight>();
        try{
            Connection con= getCon();
            
            String q = "select * from Flight NATURAL JOIN flight_airline "
                    + "NATURAL JOIN Airline WHERE departure LIKE '%"+query+"%'"
                    + " OR airlineName LIKE '%"+
                    query+"%' OR airlineNumber LIKE '%"+
                    query+"%';";
System.out.println(q);
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				//been= new UserInfo();
				String destination=rs.getString("destination");
				String departure=rs.getString("departure");
                                String departureTime=rs.getString("departureTime");
                                String airlineName=rs.getString("airlineName");
                                String airlineNumber=rs.getString("airlineNumber");
                                Airline airline= new Airline(airlineName, airlineNumber);
                           
                                Flight flight = new Flight(destination,departure,departureTime, airline);
                                flights.add(flight);
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+flights.size());
        return flights;
        
    }
}
