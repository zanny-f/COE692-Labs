/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.frontendflight.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.io.IOUtils;
import com.mycompany.helper.Flight;
import com.mycompany.helper.FlightsXML;

/**
 *
 * @author student
 */
public class Business {

    public static boolean isAuthenticated(String username, String passwrod) {
        return true;
    }

    public static FlightsXML getServices(String query, String token) throws IOException {

        Client searchclient = ClientBuilder.newClient();
        WebTarget searchwebTarget
                = searchclient.target("http://localhost:8080/SearchFlights/webresources/search");
        InputStream is
                = searchwebTarget.path(query).request(MediaType.APPLICATION_XML).get(InputStream.class);
        String xml = IOUtils.toString(is, "utf-8");
        FlightsXML flights = flightxmltoObjects(xml);
        if (token != null) {
            Client holdclient = ClientBuilder.newClient();
            WebTarget holdwebTarget
                    
//                    WHAT IS THIS
                    = holdclient.target("http://localhost:8080/BookFlight/webresources/schedule/isScheduled");
            for (Flight flight : flights.getFlights()) {

                InputStream scheduledata
                        = holdwebTarget.path(flight.getDestination()).queryParam("token", token).
                                request(MediaType.APPLICATION_XML).get(InputStream.class);
                try{
                    Flight a=flightschedulexmltoObjects(IOUtils.toString(scheduledata, "utf-8"));
                    if(a!=null)
                        flight.setTobeSchedule(true);
                    else
                        flight.setTobeSchedule(false);
                }
                catch(Exception e){
                    flight.setTobeSchedule(false);
                }
                
                
            }
        }

        return (flights);

    }

    private static FlightsXML flightxmltoObjects(String xml) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(FlightsXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            FlightsXML flights = (FlightsXML) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return flights;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Flight flightschedulexmltoObjects(String xml) {
        if(xml.isEmpty())
            return null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Flight.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Flight flight = (Flight) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            return flight;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
