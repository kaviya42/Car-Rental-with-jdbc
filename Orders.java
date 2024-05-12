package model;


public class Orders {
    private int orderID;
    private Customers customer;
    private String orderDate;
    private double totalAmount;
    public Orders(){
        
    }
    public Orders(int orderID, Customers customer, String orderDate, double totalAmount) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double calculateTotalAmount() {
       
        return 0;
    }

    public void getOrderDetails() {
        
    }

    public void updateOrderStatus(String status) {
       
    }

    public void cancelOrder() {
       
    }
}