package CS401MppAssignment.Lab_2.prob2B.prob2B_main;


import CS401MppAssignment.Lab_2.prob2B.Order;

public class Main {

    public static void main(String[] args) {

        Order order = new Order(2);

        order.addOrderLine("Coffee");
        order.addOrderLine("Mango-Juice");
        order.addOrderLine("Water");
        order.addOrderLine("Bread");

        order.printAll(order.getOrderLineList());

    }
}
