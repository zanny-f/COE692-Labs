/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helper;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @airline student
 */
    @XmlRootElement(name = "flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

 @XmlTransient
    private boolean tobeSchedule;

    public boolean isTobeSchedule() {
        return tobeSchedule;
    }

    public void setTobeSchedule(boolean tobeSchedule) {
        this.tobeSchedule = tobeSchedule;
    }
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
    public ArrayList<Airline> getAirline() {
        return airline;
    }
     public void addAirline(ArrayList<Airline> airlines) {
         for(Airline a:airlines){
        this.airline.add(new Airline(a.getAirlineName(),a.getAirlineNumber()));
         }
    }
}
