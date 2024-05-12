package model;
import exception.*;
public class OrderDetails {
    private int orderDetailID;
    private Orders order;
    private Products product;
    private int quantity;
   
    public OrderDetails(){
        
    }
    public OrderDetails(int orderDetailID, Orders order, Products product, int quantity) {
        this.orderDetailID = orderDetailID;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws InvalidDataException {
        if (quantity <= 0) {
            throw new InvalidDataException("Quantity must be a positive integer");
        }
        this.quantity = quantity;
    }

    public double calculateSubtotal() {
       
        return 0;
    }

    public void getOrderDetailInfo() {
    }
    public void updateQuantity(int newQuantity) throws InvalidDataException {
       
        if (newQuantity <= 0) {
            throw new InvalidDataException("Quantity must be a positive integer");
        }
        setQuantity(newQuantity);
    }

    public void addDiscount() {
       
    }
}