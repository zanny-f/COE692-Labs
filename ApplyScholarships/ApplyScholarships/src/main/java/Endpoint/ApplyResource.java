/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Endpoint;

import java.io.StringWriter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.*;
import Business.ApplyBusiness;
import Helper.ApplyScholarship;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("apply")
public class ApplyResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PurchaseResource
     */
    public ApplyResource() {
    }

    /**
     * Retrieves representation of an instance of endpoint.PurchaseResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("isOnHold/{firstName}")
    public String getXml(@PathParam("firstName") String firstName) {
        System.out.println(firstName);
        ApplyBusiness application = new ApplyBusiness();
        ApplyScholarship scholarship = application.getApplication(firstName);
        if (scholarship == null) {
            return("");
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ApplyScholarship.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(scholarship, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(ApplyResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }

    /**
     * PUT method for updating or creating an instance of PurchaseResource
     * @param content representation for the resource
     */
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String  updateApplication(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName)//,@FormParam("email") String email, @FormParam("phoneNumber") String phoneNumber, @FormParam("school") String school, @FormParam("gender") String gender,@FormParam("schoolYear") int schoolYear, @FormParam("GPA") double GPA) 
    {
          ApplyBusiness a = new ApplyBusiness();
          boolean bs=a.apply(firstName, lastName);//, email, phoneNumber, school, gender, schoolYear, GPA);
          System.out.println(bs);
          if(bs){
              return("Inserted");}
          else{
              return("Not inserted");}
          
    }
}
