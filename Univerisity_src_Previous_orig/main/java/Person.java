package CS401MppAssignment.Univerisity_src_Previous_orig.main.java;

import java.util.List;

public class Person {
    private Department dep;
    private List<Role> roles;

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
