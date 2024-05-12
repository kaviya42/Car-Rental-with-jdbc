package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DataConnect;

import model.Orders;

public class OrderDao {
    private Connection con;
    PreparedStatement stat;

    public OrderDao() {
        con = DataConnect.getConnect();
    }

    public void add(Orders o) {
        try {
            stat = con.prepareStatement("insert into orders values(?,?,?,?)");
            stat.setInt(1, o.getOrderID());
            stat.setInt(2, o.getCustomer().getCustomerID());
            stat.setString(3, o.getOrderDate());
            stat.setDouble(4, o.getTotalAmount());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int orderID, double totalAmount) {
        try {
            stat = con.prepareStatement("update orders set totalAmount=? where orderID=?");
            stat.setDouble(1, totalAmount);
            stat.setInt(2, orderID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(int orderID) {
        try {
            stat = con.prepareStatement("delete from orders where orderID=?");
            stat.setInt(1, orderID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show() {
        try {
            stat = con.prepareStatement("select * from orders");
            ResultSet r = stat.executeQuery();
            while (r.next()) {
                System.out.println("Order ID: " + r.getInt(1) + ", Customer ID: " + r.getInt(2) + ", Order Date: "
                        + r.getString(3) + ", Total Amount: " + r.getDouble(4));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

