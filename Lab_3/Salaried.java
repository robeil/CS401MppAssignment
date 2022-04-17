package CS401MppAssignment.Lab_3;

import java.time.LocalDate;

public class Salaried extends Employee {

    private double salary;

    public Salaried() {

    }
    public Salaried(double salary) {
        this.salary = salary;
    }
    @Override
    public double calcGrossPay(LocalDate  month, LocalDate year) {
        //calculating the monthly salary by 12 to get the salary for year
        return salary * 12;
    }
}
