import java.util.List;

//todo: Add any missing attributes, don't forget getters/setters
public class Passenger extends Role{

    private List<Reservation> reservations;

    public Passenger(){}

    public Passenger(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
