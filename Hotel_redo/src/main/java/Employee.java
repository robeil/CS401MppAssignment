//todo: Add any missing attributes, don't forget getters/setters
public class Employee extends Role{

    private String position;

    public Employee(){}

    public Employee(String position) {
        this.position = position;
    }

    public Employee(Person person, String position) {
        super(person);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
