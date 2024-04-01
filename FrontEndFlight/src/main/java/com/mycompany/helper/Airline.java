/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helper;

/**
 *
 * @author student
 */
public class Airline {
    String airlineName;
    String airlineNumber;

    public String getAirlineName() {
        return airlineName;
    }

    public String getAirlineNumber() {
        return airlineNumber;
    }

    public Airline(String airlineName, String airlineNumber) {
        this.airlineName = airlineName;
        this.airlineNumber = airlineNumber;
    }
    public Airline() {
        this.airlineName = airlineName;
        this.airlineNumber = airlineNumber;
    }
    @Override
    public String toString(){
        return(airlineName+", "+ airlineNumber);
    }
    
    
}
