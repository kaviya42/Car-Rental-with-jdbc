package MenuService;

import java.util.Scanner;

import Dao.InventoryDao;
import model.Inventory;

public class InventoryService {
    Scanner sc;
    InventoryDao idao;

    public InventoryService() {
        sc = new Scanner(System.in);
        idao = new InventoryDao();
    }

    public void addInventory() {
        Inventory i = new Inventory();
        System.out.println("Enter inventory ID:");
        i.setInventoryID(sc.nextInt());
        System.out.println("Enter product ID:");
        i.getProduct().setProductID(sc.nextInt());
        System.out.println("Enter quantity in stock:");
        i.setQuantityInStock(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter last stock update:");
        i.setLastStockUpdate(sc.nextLine());
        idao.add(i);
    }

    public void updateInventory() {
        System.out.println("Enter inventory ID:");
        int inventoryID = sc.nextInt();
        System.out.println("Enter new quantity in stock:");
        int newQuantity = sc.nextInt();
        idao.update(inventoryID, newQuantity);
    }

    public void deleteInventory() {
        System.out.println("Enter inventory ID:");
        int inventoryID = sc.nextInt();
        idao.delete(inventoryID);
    }

    public void displayInventory() {
        idao.show();
    }

}
