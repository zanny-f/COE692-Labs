package Helper;


import java.util.Date;

/**
 *
 * @author student
 */
public class flightBooked {

    String flightName;
    String flight;
    Date flightDate;
    boolean available;
    
    public flightBooked(String flightName, String flight, Date flightDate, boolean available) {
        this.flightName = flightName;
        this.flight = flight;
        this.flightDate = flightDate;
        this.available=available;
    }
        
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getflightName() {
        return flightName;
    }

    public void setflightName(String flightName) {
        this.flightName = flightName;
    }

    public String getflight() {
        return flight;
    }

    public void setflight(String flight) {
        this.flight = flight;
    }

    public Date getflightDate() {
        return flightDate;
    }

    public void setflightDate(Date flightDate) {
        this.flightDate = flightDate;
    }
    
    
}
