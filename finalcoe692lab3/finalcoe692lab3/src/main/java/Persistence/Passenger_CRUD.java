package Persistence;
import Helper.PassengerInfo;
import java.sql.*;

/**
 *
 * @author student
 */
public class Passenger_CRUD {
    private static Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Flight?&serverTimezone=UTC","root","student");
            System.out.println("Connection established.");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }

    
    public static PassengerInfo read(String username, String password){
        PassengerInfo bean = null;
        
        try{
            Connection con = getCon();
            
            String q = "select * FROM passengerInfo WHERE username =" +'"' + username + '"'+ ";";
            System.out.println(q);
            PreparedStatement ps = con.prepareStatement(q);
            
            //ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            //if there is a valid response in the query
                    
            if(rs.next()){
                String fullname = rs.getString("fullName");
                String user = rs.getString("username");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                String pass = rs.getString("password");
                System.out.println(password);
                if(pass.equals(password)){
                    bean = new PassengerInfo(fullname, user, email, phoneNumber, pass);
                }  
            }           
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return bean;
    }
    
    public static void create(String fullname, String username, String email, String phoneNumber, String password) {
    try {
        Connection con = getCon();
        Statement stmt = con.createStatement();
        String values = "'" + fullname + "', '" + username + "', '" + email + "', '" + phoneNumber + "', '" + password + "' " ;
       String q = "INSERT INTO passengerInfo (fullname, username, email, phoneNumber,password) VALUES (" + values + ");";
        System.out.println(q); 
       stmt.execute(q);
        System.out.println("Inserted");
        con.close();
    } catch(Exception e) {
        System.out.println(e);
    }
}
}
