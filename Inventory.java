package model;
import exception.*;
public class Inventory {
    private int inventoryID;
    private Products product;
    private int quantityInStock;
    private String lastStockUpdate;
    public Inventory(){
        
    }
    public Inventory(int inventoryID, Products product, int quantityInStock, String lastStockUpdate) {
        this.inventoryID = inventoryID;
        this.product = product;
        this.quantityInStock = quantityInStock;
        this.lastStockUpdate = lastStockUpdate;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getLastStockUpdate() {
        return lastStockUpdate;
    }

    public void setLastStockUpdate(String lastStockUpdate) {
        this.lastStockUpdate = lastStockUpdate;
    }

    public void addToInventory(int quantity) {
        
    }

    public void removeFromInventory(int quantity) throws InsufficientStockException {
        // Implement logic to remove from inventory
        if (quantity > quantityInStock) {
            throw new InsufficientStockException("Insufficient stock");
        }
        quantityInStock -= quantity;
    }

    public void updateStockQuantity(int newQuantity) {
    }

    public boolean isProductAvailable(int quantityToCheck) {
       
        return true;
    }

    public double getInventoryValue() {
       
        return 0;
    }

    public void listLowStockProducts(int threshold) {
        // Implement logic to list products with quantities below a specified threshold
    }

    public void listOutOfStockProducts() {
        if (quantityInStock == 0) {
            System.out.println("Product Name: " + product.getProductName() + ", Out of stock");
        }
    }
    
    public void listAllProducts() {
        // Implement logic to list all products in the inventory, along with their quantities
        System.out.println("Product Name: " + product.getProductName() + ", Quantity in stock: " + quantityInStock);
    }
}
