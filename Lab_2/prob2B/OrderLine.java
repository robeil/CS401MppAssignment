package CS401MppAssignment.Lab_2.prob2B;

public class OrderLine {

    private Order order;
    private String name;

    //package level
    OrderLine(Order order,String name){
        this.order = order;
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" + order +" ,"+
                "name='" + name  +
                '}'+ "\n";
    }
}
