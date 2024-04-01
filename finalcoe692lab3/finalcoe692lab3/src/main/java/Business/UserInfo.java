package Business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Helper.flightBooked;
import java.util.ArrayList;


/**
 *
 * @author student
 */
class UserInfo {
    /*to be completed
    For now, we just add book info to make the example work. This class must be completed in future
    */
    //private ArrayList <BookBorro
    private ArrayList <flightBooked> bookedFlight = new ArrayList<>();
    public void addflight(flightBooked flight){
        bookedFlight.add(flight);
    }
    public ArrayList<flightBooked> getflightBooked(){
        return bookedFlight;
    }
}
