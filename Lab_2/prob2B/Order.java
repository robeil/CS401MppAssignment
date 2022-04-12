package CS401MppAssignment.Lab_2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderNum;
    private List<OrderLine> orderLineList;

    public Order(int orderNum){
        this.orderNum = orderNum;
        this.orderLineList = new ArrayList<>();
    }
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    //creating new line
    public void addOrderLine(String name){
       OrderLine newO = new OrderLine(this,name);
       orderLineList.add(newO);

    }
    public List<OrderLine> getOrderLineList() {
        //orderLineList.add(addOrderLine());
        return orderLineList;
    }
    // adding the new crated line order to the list
    public void setOrderLineList(List<OrderLine> orderLineList) {
     // orderLineList.add(addOrderLine());
        this.orderLineList = orderLineList;
    }

    public void printAll(List<OrderLine> orderLineList){
        System.out.println(orderLineList);
    }
    @Override
    public String toString() {
        return
                "OrderNum=" + orderNum;
//                ",orderLineList=" + orderLineList;

    }
}

