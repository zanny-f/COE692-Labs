/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.searchflights.business;

import com.mycompany.searchflights.helper.FlightsXML;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import com.mycompany.searchflights.helper.Flight;
import com.mycompany.searchflights.persistence.Flight_CRUD;

/**
 * CHANGE THIS TO YOURS
 *
 * @author student
 */
public class SearchBusiness {
    
    public  FlightsXML getFlightsByQuery(String query){
       Set<Flight> flights = Flight_CRUD.searchForFlights(query);
       Map<String ,Flight> allAirlinesFlights= new HashMap ();
           System.out.println("&&&&&&&&&&&&&&&&&&&&&&"+ flights.size());
        for(Flight flight : flights){
            if(allAirlinesFlights.containsKey(flight.getDestination())){
                allAirlinesFlights.get(flight.getDestination()).addAirline(flight.getAirlines());
            }
            else{
               
                allAirlinesFlights.put(flight.getDestination(),flight );
            }
        }
        System.out.println("**********************"+ allAirlinesFlights.size());
        FlightsXML fs;
        fs = new FlightsXML();
        fs.setFlight(new ArrayList(allAirlinesFlights.values()));
        return (fs);
    }
    
      
}
