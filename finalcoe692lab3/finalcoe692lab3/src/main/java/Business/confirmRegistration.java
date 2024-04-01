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


@WebServlet(name = "confirmRegistration", urlPatterns = {"/confirmRegistration"})
public class confirmRegistration extends HttpServlet {
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
        RequestDispatcher rd = request.getRequestDispatcher("confirmRegistration.jsp");
        rd.forward(request, response);
  
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Take the info given in the form
        String fullName =  (String)request.getParameter("fullName");
        String username = (String)request.getParameter("username");
        String email =  (String)request.getParameter("email");
        String phoneNumber = (String)request.getParameter("phoneNumber");
        String password =  (String)request.getParameter("password");
        
        
        request.getSession().setAttribute("fullName", fullName);
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("phoneNumber", phoneNumber);
        request.getSession().setAttribute("password", password);
        Passenger_CRUD.create(fullName, username, email, phoneNumber, password);

        RequestDispatcher rd = request.getRequestDispatcher("confirmRegistration.jsp");
        rd.forward(request, response);

    }
}
    
