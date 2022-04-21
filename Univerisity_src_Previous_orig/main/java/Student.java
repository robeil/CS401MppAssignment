package CS401MppAssignment.Univerisity_src_Previous_orig.main.java;

import java.util.List;

public class Student extends Role {
private List<Grade> grades;

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}