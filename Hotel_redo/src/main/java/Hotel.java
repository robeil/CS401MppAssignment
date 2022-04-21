import java.util.List;

//todo: Add any missing attributes, don't forget getters/setters
public class Hotel {
    private String name;
    private List<Employee> employees;
    private List<Reservation> reservations;

    public Hotel(){}

    public Hotel(String name, List<Employee> employees, List<Reservation> reservations) {
        this.name = name;
        this.employees = employees;
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
