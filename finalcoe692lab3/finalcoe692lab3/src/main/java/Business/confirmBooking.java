package Business;
import Persistence.*;
import Helper.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "confirmBooking", urlPatterns = {"/confirmBooking"})
public class confirmBooking extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("confirmBooking.jsp");
        rd.forward(request, response);
  
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Take the info given in the form
        String firstName =  (String)request.getParameter("firstName");
        String lastName = (String)request.getParameter("lastName");
        String email =  (String)request.getParameter("email");
        String phoneNumber = (String)request.getParameter("phoneNumber");
        String numPassengers =  (String)request.getParameter("numPassengers");
        String cardNumber = (String)request.getParameter("cardNumber");
   
        request.getSession().setAttribute("firstName", firstName);
        request.getSession().setAttribute("lastName", lastName);
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("phoneNumber", phoneNumber);
        request.getSession().setAttribute("numPassengers", numPassengers);
        request.getSession().setAttribute("cardNumber", cardNumber);
        Flight_CRUD.create(firstName, lastName, email, phoneNumber, numPassengers, cardNumber);
        System.out.println(firstName);
        RequestDispatcher rd = request.getRequestDispatcher("confirmBooking.jsp");
        System.out.println("made lfight");
        rd.forward(request, response);

    }
}
