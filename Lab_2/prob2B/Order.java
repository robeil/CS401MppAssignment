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

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }
}

