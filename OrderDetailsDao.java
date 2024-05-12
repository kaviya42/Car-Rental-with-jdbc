package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DataConnect;
import model.OrderDetails;


public class OrderDetailsDao {
    private Connection con;
    PreparedStatement stat;

    public OrderDetailsDao() {
        con = DataConnect.getConnect();
    }

    public void add(OrderDetails od) {
        try {
            stat = con.prepareStatement("insert into orderdetails values(?,?,?,?)");
            stat.setInt(1, od.getOrderDetailID());
            stat.setInt(2, od.getOrder().getOrderID());
            stat.setInt(3, od.getProduct().getProductID());
            stat.setInt(4, od.getQuantity());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int orderDetailID, int newQuantity) {
        try {
            stat = con.prepareStatement("update orderdetails set quantity=? where orderDetailID=?");
            stat.setInt(1, newQuantity);
            stat.setInt(2, orderDetailID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(int orderDetailID) {
        try {
            stat = con.prepareStatement("delete from orderdetails where orderDetailID=?");
            stat.setInt(1, orderDetailID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show() {
        try {
            stat = con.prepareStatement("select * from orderdetails");
            ResultSet r = stat.executeQuery();
            while (r.next()) {
                System.out.println("Order Detail ID: " + r.getInt(1) + ", Order ID: " + r.getInt(2) + ", Product ID: "
                        + r.getInt(3) + ", Quantity: " + r.getInt(4));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

