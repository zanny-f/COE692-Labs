package Business;


//import Presistence.Account_CRUD;
import Helper.flightBooked;
import Persistence.Passenger_CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author student
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        Helper.PassengerInfo uinfo= Passenger_CRUD.read(username, password);
        UserInfo u = getUserInfo(username, password);
        if (uinfo==null){
            RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else {
            request.getSession().setAttribute("uname", username);
            request.setAttribute("flightBookedInfo", u.getflightBooked());
            System.out.println(username);
            RequestDispatcher rd= request.getRequestDispatcher("userbooks.jsp");
            rd.forward(request, response);
            
        }
        
        
     
    }

    private UserInfo getUserInfo(String uname, String password) {
        /**
         * to be completed. For now, we just return a user info object that has a default book in a default date;
         * This method must return null when user name and password is incorrect
         * otherwise it must return an object containing all books that have been borrowed by the user, in addition to user information like name, address, ...
         */
        UserInfo uf= new UserInfo();
   
        
       try {
           uf.addflight(new flightBooked("Air Canada", "AC 131", new SimpleDateFormat("YYYY-MM-dd").parse("2022-02-07"), false));
           uf.addflight(new flightBooked("WestJet", "WJA 107", new SimpleDateFormat("YYYY-MM-dd").parse("2022-02-20"), true));
       } catch (ParseException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Error");
       }
        return uf;
    }
    

}

//package Business;
//
//import Helper.PassengerInfo;
//import Presistence.Passenger_CRUD;
//import Presistence.Flight_CRUD;
//import java.io.*;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author student
// */
//@WebServlet(name = "Login", urlPatterns = {"/Login"})
//public class Login extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Login</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = (String) request.getParameter("username");
//        String password = (String) request.getParameter("password");
//        PassengerInfo user = Passenger_CRUD.read(username, password);
//        
//        if (user == null) {
//            RequestDispatcher rd = request.getRequestDispatcher("loginfailed.jsp");
//            rd.forward(request, response);
//        }
//        else { 
//            user.addAccounts(Flight_CRUD.read(username));
//            request.getSession().setAttribute("uinfo", user);
//            RequestDispatcher rd = request.getRequestDispatcher("userbooks.jsp");
//            rd.forward(request, response);
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
