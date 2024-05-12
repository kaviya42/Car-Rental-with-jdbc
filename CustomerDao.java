package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DataConnect;
import model.Customers;
//import exception.*;

public class CustomerDao {
    private Connection con;
    PreparedStatement stat;

    public CustomerDao() {
        con = DataConnect.getConnect();
    }

    public void add(Customers c) {
        try {
            stat = con.prepareStatement("insert into customers values(?,?,?,?,?,?)");
            stat.setInt(1, c.getCustomerID());
            stat.setString(2, c.getFirstName());
            stat.setString(3, c.getLastName());
            stat.setString(4, c.getEmail());
            stat.setString(5, c.getPhone());
            stat.setString(6, c.getAddress());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int customerID, String email, String phone, String address) {
        try {
            stat = con.prepareStatement("update customers set email=?, phone=?, address=? where customerID=?");
            stat.setString(1, email);
            stat.setString(2, phone);
            stat.setString(3, address);
            stat.setInt(4, customerID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(int customerID) {
        try {
            stat = con.prepareStatement("delete from customers where customerID=?");
            stat.setInt(1, customerID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show() {
        try {
            stat = con.prepareStatement("select * from customers");
            ResultSet r = stat.executeQuery();
            while (r.next()) {
                System.out.println("Customer ID: " + r.getInt(1) + ", First Name: " + r.getString(2) + ", Last Name: "
                        + r.getString(3) + ", Email: " + r.getString(4) + ", Phone: " + r.getString(5) + ", Address: "
                        + r.getString(6));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
