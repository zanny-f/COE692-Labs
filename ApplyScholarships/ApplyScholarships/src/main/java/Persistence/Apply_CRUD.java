/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import Helper.ApplyScholarship;

public class Apply_CRUD {
    private static Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_flight?&serverTimezone=UTC","root","student");
            System.out.println("Connection established.");
	}
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }

    public static boolean addApplication(String firstName, String lastName){//, String email, String phoneNumber, String school, String gender, int schoolYear, double GPA) {
    try {
        Connection con = getCon();
        Statement stmt = con.createStatement();
       // String values = "'" + "firstName" + "', '" + "lastName" + "', '" + "email" + "', '" + "phoneNumber" + "', '" + "school" + "', '" + "gender" + "', " + "GPA" + ", " + "schoolYear" ;
        String q = "INSERT INTO SCHOLARSHIP_APPLY (destination, userid, arrivaldate)";//, email, phoneNumber, school, gender, GPA, schoolYear) VALUES (" + values + ");";
        System.out.println(q); 
        stmt.execute(q);
        System.out.println("Inserted");
        con.close();
        return true;
    } 
    catch(Exception e) {
        System.out.println(e);
        return false;
    }
}

    
    public static ApplyScholarship getApplication(String firstName){
        ApplyScholarship application=null;
        try{
            Connection con= getCon();
            
            String q = "select * from SCHOLARSHIP_APPLY "
                    + " WHERE "
                    
                    + "firstName = '"+firstName+"';";
            System.out.println(q);

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				
				
                        String applicantFName1 = rs.getString("firstName");
                        String applicantLName1 = rs.getString("lastName");
                        String applicantEmail1 = rs.getString("email");
                        String applicantPhone1 = rs.getString("phoneNumber");
                        String school = rs.getString("school");
                        String gender = rs.getString("gender");
                        int year = rs.getInt("schoolYear");
                        double GPA = rs.getDouble("GPA");

                        application = new ApplyScholarship(applicantFName1 ,applicantLName1, applicantEmail1, applicantPhone1, school, gender, year, GPA);
                                
                                
                        }
			
			con.close();

		}
        catch(Exception e){
            System.out.println(e);
        }   
        return application;    
    }
}
