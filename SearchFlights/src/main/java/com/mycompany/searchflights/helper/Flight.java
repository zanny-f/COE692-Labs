/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.searchflights.helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @airline student
 */
@XmlRootElement(name = "flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {
    
    private String destination; 
    private String departure;
    private String departureTime;
    ArrayList<Airline> airline ;

    public Flight(){
        
    }
    public Flight(String destination, String departure, String departureTime, Airline airline) {
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.airline= new ArrayList<Airline>();
        this.airline.add(new Airline(airline.getAirlineName(), airline.getAirlineNumber()));
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDepartureTime() {
        return departureTime;
    }
    public ArrayList<Airline> getAirlines() {
        return airline;
    }
     public void addAirline(ArrayList<Airline> airlines) {
         for(Airline a:airlines){
        this.airline.add(new Airline(a.getAirlineName(),a.getAirlineNumber()));
         }
    }
    /*@Override
    public int hashCode() {
        return (Objects.hash(destination));
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Flight other = (Flight) obj;
        if (destination.equals(other.destination))
            return true;
        else return (false);
        
    }*/
    
}
