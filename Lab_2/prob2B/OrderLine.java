package CS401MppAssignment.Lab_2.prob2B;

public class OrderLine {

    private Order order;

   public OrderLine(Order order){
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "order=" + order +
                '}';
    }
}
