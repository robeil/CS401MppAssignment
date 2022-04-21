import java.time.LocalDateTime;
import java.util.Date;


//todo: Add any missing attributes, don't forget getters/setters
public class Reservation {

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private boolean suite;
    private Passenger passenger;
    private Hotel hotel;

    public Reservation(){}

    public Reservation(LocalDateTime checkIn, LocalDateTime checkOut, boolean suite, Passenger passenger, Hotel hotel) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.suite = suite;
        this.passenger = passenger;
        this.hotel = hotel;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
