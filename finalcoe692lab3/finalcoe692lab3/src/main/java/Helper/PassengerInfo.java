package Helper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author student
 */

public class PassengerInfo {
    private String fullname;
    private String password;
    private String username;
    private String email;
    private String phoneNumber;
    private ArrayList<PassengerInfo> Passenger_Info;
    
    public PassengerInfo(String fullname, String username, String email, String phoneNumber, String password){        
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    
    public ArrayList<PassengerInfo> getPassenger_Info(){
        return this.Passenger_Info;
    }
    
    public void addPassenger_Info(ArrayList<PassengerInfo> Passenger_Info){
        this.Passenger_Info = Passenger_Info;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getFullName(){
        return this.fullname;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPhNum() {
        return phoneNumber;
    }

    public void setPhNum(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }  
    public void setFullName(String username) {
        this.fullname = fullname;
    }  
}