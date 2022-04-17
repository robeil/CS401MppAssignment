package CS401MppAssignment.Lab_3;

import java.time.LocalDate;

public abstract class Employee {

    private int empId;

    public Employee(){

    }

    public Employee(int empId) {
        this.empId = empId;
    }
    public void print(){

    }
    PayCheck calcCompensation(LocalDate month,LocalDate year){
        PayCheck payCheck = new PayCheck();
        payCheck.setGrossPay(calcGrossPay(month,year)); //fixme please !!!!!!!!!!!!!!
        return payCheck;
    }

    public abstract double calcGrossPay(LocalDate month, LocalDate year);
}
