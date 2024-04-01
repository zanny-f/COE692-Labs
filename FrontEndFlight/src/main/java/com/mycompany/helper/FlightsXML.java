/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement(name = "flights")
@XmlAccessorType (XmlAccessType.FIELD)
       public class FlightsXML{
     @XmlElement(name="flight")
           private ArrayList<Flight> flights;
           
           
           public List<Flight>getFlights(){
               return flights;
               
           }
           FlightsXML(){
               
               
           }
           public void setFlight(ArrayList<Flight> fs){
               flights=fs;
               
           }
           
       }