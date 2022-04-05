package CS401MppAssignment.Lab_2.prob2A.prob2A_main;

import CS401MppAssignment.Lab_2.prob2A.GradeReport;
import CS401MppAssignment.Lab_2.prob2A.Student;

public class Main {
    public static void main(String[] args) {

        //Accessing from student to grade-reposrt
        Student s1 = new Student("Robeil");
        s1.getGradeReport();
        System.out.println("From student -> "+ s1.getGradeReport());
        //Accessing from grade-report to customer
        GradeReport gr = s1.getGradeReport();
        gr.getStudent().getName();
        System.out.println("From gradeReport -> "+ gr.getStudent().getName());
    }
}
