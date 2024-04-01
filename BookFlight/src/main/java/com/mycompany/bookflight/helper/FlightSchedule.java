/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bookflight.helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
 @XmlRootElement(name = "flight")
 @XmlAccessorType(XmlAccessType.FIELD)
public class FlightSchedule {
    
    private String destination; 

    public FlightSchedule(String destination, String scheduleDeparture, String username) {
        this.destination = destination;
        this.scheduleDeparture = scheduleDeparture;
        this.username = username;
    }
  
    public FlightSchedule() {
        this.destination = "";
        this.scheduleDeparture = "";
        this.username = "";
    }
    private String scheduleDeparture;
    private String username;

    public String getDestination() {
        return destination;
    }

    public String getScheduleDeparture() {
        return scheduleDeparture;
    }

    public String getUsername() {
        return username;
    }


   
    
}
