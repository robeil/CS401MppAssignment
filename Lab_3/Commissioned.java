package CS401MppAssignment.Lab_3;

import java.time.LocalDate;
import java.util.List;

public class Commissioned extends Employee {

    private double commission;
    private double baseSalary;
    private List<Order> orderList;

    public Commissioned(){

    }
    public Commissioned(double commission, double baseSalary, List<Order> orderList) {
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orderList = orderList;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    //adding order to the list
    public void createAndAddOrderToList(int orderNo, LocalDate orderDate, int orderAmount, Commissioned commissioned){
        Order order = new Order(orderNo,orderDate,orderAmount,commissioned);
        orderList.add(order);
    }
//    public double previousYear(LocalDate localDate){
//        double preYear = localDate.getYear()-1;
//        return preYear;
//    }
    @Override
    public double calcGrossPay(LocalDate month, LocalDate year) {

//        if (year == LocalDate.now().getYear()-1) {
            //traversing through the list to get the total amount
            double totalAmount = 0.0;
            for (Order o : orderList) {
                totalAmount += o.getOrderAmount();
            }
            double monthlyGrossPay = baseSalary + (totalAmount * commission);
            return monthlyGrossPay * 12;
//        } else {
//
//        }
    }
}
