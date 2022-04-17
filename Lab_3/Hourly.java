package CS401MppAssignment.Lab_3;

import java.time.LocalDate;

public class Hourly extends Employee {

    private double hourlyWage;
    private double hoursPerWeek;

    public Hourly(){

    }
    public Hourly(double hourlyWage, double hoursPerWeek) {
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }
    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calcGrossPay(LocalDate month, LocalDate  year) {
        //calculating monthly income and multiply by 12 to get the yearly amount
        double monthlyGrossPay = (hourlyWage * hoursPerWeek) * 4;
        return monthlyGrossPay * 12;
    }

}
