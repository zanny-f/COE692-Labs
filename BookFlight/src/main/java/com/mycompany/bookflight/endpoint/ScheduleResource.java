/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookflight.endpoint;

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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.mycompany.bookflight.business.ScheduleBusiness;
import com.mycompany.bookflight.helper.FlightSchedule;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("schedule")
public class ScheduleResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public ScheduleResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ryerson.ca.searchbook.endpoint.SearchResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("isScheduled/{destination}")
    public String getXml(@PathParam("destination") String destination) {
        System.out.println(destination);
        ScheduleBusiness schedule = new ScheduleBusiness();
        FlightSchedule flight = schedule.getFlights(destination);
        if (flight == null) {
            return("");
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(FlightSchedule.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(flight, sw);

            return (sw.toString());

        } catch (JAXBException ex) {
            Logger.getLogger(ScheduleResource.class.getName()).log(Level.SEVERE, null, ex);
            return ("error happened");
        }
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("update")
    public String  updateFlightSchedule(@FormParam("destination") String destination, @FormParam("userid") String userid) 
    {
          ScheduleBusiness schedule = new ScheduleBusiness();
          boolean fs=schedule.schedule(destination, userid);
          if(fs)
              return("Inserted");
          else
              return("Not inserted");
          
    }
}
