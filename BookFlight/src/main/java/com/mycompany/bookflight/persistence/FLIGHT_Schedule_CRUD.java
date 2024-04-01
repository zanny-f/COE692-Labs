/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookflight.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import com.mycompany.bookflight.helper.FlightSchedule;

/**
 *
 * @author student
 */
public class FLIGHT_Schedule_CRUD {
    private static Connection getCon(){
    Connection con=null;
     try{
         
         Class.forName("com.mysql.cj.jdbc.Driver");
        //con=DriverManager.getConnection("jdbc:mysql://db:3306/hold_LBS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
       
        
//        CHANGE THIS
        
        
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_flight?autoReconnect=true&useSSL=false", "root", "student");
        System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
    }
    
    
    
    public static boolean addSchedule(String destination, String username){
      
        try{
            Connection con= getCon();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate date = LocalDate.now();
            String q = "insert into Flight_Schedule "
                    + "(destination, userid, arrivaldate) values "
                    + "('"+destination+"', "
                    +"'"+username+"', "
                    +"'"+date.format(formatter)+"');";
            Statement stmt = con.createStatement();   
            System.out.println(q);
            stmt.execute(q);
			con.close();
                        return true;

		}catch(Exception e){System.out.println(e);
                return false;
                }
 
        
    }
    public static FlightSchedule getScheduleFlight(String destination){
        FlightSchedule flight=null;
        try{
            Connection con= getCon();
            
            String q = "select * from Flight_Schedule "
                    + " WHERE "
                    
                    + "destination = '"+destination+"';";
            System.out.println(q);

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				
				
                                String date=rs.getDate("arrivaldate").toString();
                                String username=rs.getString("userid").toString();
                                
                                 flight = new FlightSchedule(destination,date,username);
                                
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            
    
        return flight;
        
    }

    public static boolean addSchedule(String destination, String userid, String scheduledeparture) {
      return( addSchedule(destination, userid));
    }
}
