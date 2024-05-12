package model;
import exception.*;
public class Products {
    private int productID;
    private String productName;
    private String description;
    private double price;

    public Products(){
        
    }
    public Products(int productID, String productName, String description, double price) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidDataException {
        if (price < 0) {
            throw new InvalidDataException("Price cannot be negative");
        }
        this.price = price;
    }

    public void getProductDetails() {
        
    }

    public void updateProductInfo(String description, double price) throws InvalidDataException {
       
        if (description != null && !description.isEmpty()) {
            setDescription(description);
        }
        if (price >= 0) {
            setPrice(price); // Corrected
        }
    }
    

    public boolean isProductInStock() {
        
        return true;
    }
}