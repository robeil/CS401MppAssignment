package CS401MppAssignment.Lab_2.prob2B.prob2B_main;


import CS401MppAssignment.Lab_2.prob2B.Order;
import CS401MppAssignment.Lab_2.prob2B.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Order o1 = new Order(2); 
        OrderLine ol1 = new OrderLine(o1);//fixme ---->
        OrderLine ol2 = new OrderLine(o1);

        List<OrderLine> orderLines = new ArrayList<>(); //fixme ------>
        orderLines.add(ol1);
        orderLines.add(ol2);

        System.out.println("We should get 2 ---> " + ol2.getOrder().getOrderNum());

    }
}
