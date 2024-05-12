package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DataConnect;
import model.Inventory;



public class InventoryDao {
    private Connection con;
    PreparedStatement stat;

    public InventoryDao() {
        con = DataConnect.getConnect();
    }

    public void add(Inventory i) {
        try {
            stat = con.prepareStatement("insert into inventory values(?,?,?,?)");
            stat.setInt(1, i.getInventoryID());
            stat.setInt(2, i.getProduct().getProductID());
            stat.setInt(3, i.getQuantityInStock());
            stat.setString(4, i.getLastStockUpdate());
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int inventoryID, int newQuantity) {
        try {
            stat = con.prepareStatement("update inventory set quantityInStock=? where inventoryID=?");
            stat.setInt(1, newQuantity);
            stat.setInt(2, inventoryID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(int inventoryID) {
        try {
            stat = con.prepareStatement("delete from inventory where inventoryID=?");
            stat.setInt(1, inventoryID);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show() {
        try {
            stat = con.prepareStatement("select * from inventory");
            ResultSet r = stat.executeQuery();
            while (r.next()) {
                System.out.println("Inventory ID: " + r.getInt(1) + ", Product ID: " + r.getInt(2)
                        + ", Quantity in Stock: " + r.getInt(3) + ", Last Stock Update: " + r.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}