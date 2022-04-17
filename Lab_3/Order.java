package CS401MppAssignment.Lab_3;

import java.time.LocalDate;

public class Order {

    private int orderNo;
    private LocalDate orderDate;
    private int orderAmount;
    private Commissioned commissioned;

    Order(int orderNo, LocalDate orderDate, int orderAmount, Commissioned commissioned) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.commissioned = commissioned;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Commissioned getCommissioned() {
        return commissioned;
    }

    public void setCommissionedList(Commissioned commissioned) {
        this.commissioned = commissioned;
    }
}
