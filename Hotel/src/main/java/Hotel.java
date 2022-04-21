import java.util.List;

//todo: Add any missing attributes, don't forget getters/setters
public class Hotel {

    private String name;
    private List<Reservation> reservations;
    private List<Employee> employees;

    public Hotel(){}

    public Hotel(String name, List<Reservation> reservations, List<Employee> employees) {
        this.name = name;
        this.reservations = reservations;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
