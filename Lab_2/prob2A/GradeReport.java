package CS401MppAssignment.Lab_2.prob2A;

public class GradeReport {

    private Student student;
    //package level
   GradeReport(Student student){
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "GradeReport{" +
                "student=" + student.getName() +
                '}';
    }
}
