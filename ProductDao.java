package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DataConnect;

import model.Products;

public class ProductDao {
    private Connection con;
    PreparedStatement stat;

    public ProductDao() {
        con = DataConnect.getConnect();
    }

    public void add(Products p) {
        try {
            stat = con.prepareStatement("insert into products values(?,?,?,?)");
            stat.setInt(1, p.getProductID());
            stat.setString(2, p.getProductName());
            stat.setString(3, p.getDescription());
            stat.setDouble(4, p.getPrice());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int productID, double price) {
        try {
            stat = con.prepareStatement("update products set  price=? where productID=?");
            
            stat.setDouble(1, price);
            stat.setInt(2, productID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(int productID) {
        try {
            stat = con.prepareStatement("delete from products where productID=?");
            stat.setInt(1, productID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show() {
        try {
            stat = con.prepareStatement("select * from products");
            ResultSet r = stat.executeQuery();
            while (r.next()) {
                System.out.println("Product ID: " + r.getInt(1) + ", Product Name: " + r.getString(2) + ", Description: "
                        + r.getString(3) + ", Price: " + r.getDouble(4));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}