/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.holdbook.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import ryerson.ca.holdbook.helper.BookHold;

/**
 *
 * @author student
 */
public class BOOK_Hold_CRUD {
    private static Connection getCon(){
    Connection con=null;
     try{
         
         Class.forName("com.mysql.cj.jdbc.Driver");
        //con=DriverManager.getConnection("jdbc:mysql://db:3306/hold_LBS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
       
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hold_LBS?autoReconnect=true&useSSL=false", "root", "student");
        System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
    }
    
    
    
    public static boolean addHold(String isbn, String username){
      
        try{
            Connection con= getCon();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate date = LocalDate.now();
            String q = "insert into BOOK_Hold "
                    + "(isbn, userid, startdate) values "
                    + "('"+isbn+"', "
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
    public static BookHold getHoldBook(String isbn){
        BookHold book=null;
        try{
            Connection con= getCon();
            
            String q = "select * from BOOK_Hold "
                    + " WHERE "
                    
                    + "isbn = '"+isbn+"';";
            System.out.println(q);

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				
				
                                String date=rs.getDate("startdate").toString();
                                String username=rs.getString("userid").toString();
                                
                                 book = new BookHold(isbn,date,username);
                                
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            
    
        return book;
        
    }

    public static boolean addHold(String isbn, String userid, String holddate) {
      return( addHold(isbn, userid));
    }
}
