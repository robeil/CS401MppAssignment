import java.util.List;

//todo: Add any missing attributes, don't forget getters/setters
public class Person {

    private List<Role> roles;
    private String firstName;
    private String lastName;

    public Person(){}

    public Person(List<Role> roles, String firstName, String lastName) {
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
