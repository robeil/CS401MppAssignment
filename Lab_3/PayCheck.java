package CS401MppAssignment.Lab_3;

public final class PayCheck {

    private double grossPay;
    private double fica;
    private double state;
    private double local;
    private double medicare;
    private double socialSecurity;

    public PayCheck(){

    }
    public PayCheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }
    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getFica() {
        return fica;
    }

    public void setFica(double fica) {
        this.fica = fica;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }

    public double getLocal() {
        return local;
    }

    public void setLocal(double local) {
        this.local = local;
    }

    public double getMedicare() {
        return medicare;
    }

    public void setMedicare(double medicare) {
        this.medicare = medicare;
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(long socialSecurity) {
        this.socialSecurity = socialSecurity;
    }
    //Calculating net-pay
    public void getNetPay(){

        double fica = getGrossPay() * 23;
        double state = getGrossPay() * 0.05;
        double local = getGrossPay() * 0.01;
        double medicare = getGrossPay() * 0.03;
        double socialSecurity = getGrossPay() * 0.075;
        //calculating  net-pay
        double netPay = getGrossPay() - fica - state - medicare - socialSecurity;
        System.out.println("Net pay: " + netPay);
    }
    //Printing all the details
    public void print(){
        System.out.print( "PayCheck{" +
                "grossPay=" + grossPay +
                ", fica=" + fica +
                ", state=" + state +
                ", local=" + local +
                ", medicare=" + medicare +
                ", socialSecurity=" + socialSecurity +
                '}');
    }
}
