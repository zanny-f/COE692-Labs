/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookflight.business;



import com.mycompany.bookflight.helper.FlightSchedule;
import com.mycompany.bookflight.persistence.FLIGHT_Schedule_CRUD;

/**
 *
 * @author student
 */
public class ScheduleBusiness {

   



    public FlightSchedule getFlights(String destination) {
        FlightSchedule fs = FLIGHT_Schedule_CRUD.getScheduleFlight(destination);

        return (fs);
    }

public boolean schedule(String destination, String userid) {
       
        return (FLIGHT_Schedule_CRUD.addSchedule(destination, userid));
    }

    
}
