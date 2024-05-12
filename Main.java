package client;

import java.util.Scanner;

import MenuService.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CustomerService cu = new CustomerService();
        ProductService pr = new ProductService();
        OrderService or = new OrderService();
        OrderDetailsService orD= new OrderDetailsService();
        InventoryService in = new InventoryService();

        
        while (true) {
            int ch;
            System.out.println("1. Customer");
            System.out.println("2. Product");
            System.out.println("3. Order");
            System.out.println("4. Order Details");
            System.out.println("5. Inventory");
            System.out.println("6. Exit");
            System.out.println("Choose an option:");
            ch = sc.nextInt();
            if(ch==1){
                while (true) {
                    int cch;
                    System.out.println("1.create");
                    System.out.println("2.update");
                    System.out.println("3. delete");
                    System.out.println("4. show");
                    System.out.println("Choose an option:");
                    cch = sc.nextInt();
            if(cch==1){
                cu.addCustomer();
            }else if(cch==2){
                cu.updateCustomer();
            }
            else if(cch==3){
                cu.deleteCustomer();
            }
            else if(cch==4){
                cu.displayCustomers();
            }
            else
               break;
            }}
        else if(ch==2){
            while (true) {
                int cch;
                System.out.println("1.create");
                System.out.println("2.update");
                System.out.println("3. delete");
                System.out.println("4. show");
                System.out.println("Choose an option:");
                cch = sc.nextInt();
        if(cch==1){
            pr.addProduct();
        }else if(cch==2){
            pr.updateProduct();
        }
        else if(cch==3){
           pr.deleteProduct();
        }
        else if(cch==4){
            pr.displayProducts();
        }
        else
           break;
        }
        }
        else if(ch==3){
            while (true) {
                int cch;
                System.out.println("1.create");
                System.out.println("2.update");
                System.out.println("3. delete");
                System.out.println("4. show");
                System.out.println("Choose an option:");
                cch = sc.nextInt();
        if(cch==1){
            or.addOrder();
        }else if(cch==2){
           or.updateOrder();;
        }
        else if(cch==3){
           or.deleteOrder();
        }
        else if(cch==4){
            or.displayOrders();
        }
        else
           break;
        }
        }
        else if(ch==4){
            while (true) {
                int cch;
                System.out.println("1.create");
                System.out.println("2.update");
                System.out.println("3. delete");
                System.out.println("4. show");
                System.out.println("Choose an option:");
                cch = sc.nextInt();
        if(cch==1){
            orD.addOrderDetail();
        }else if(cch==2){
           orD.updateOrderDetails();
        }
        else if(cch==3){
           orD.deleteOrderDetails();
        }
        else if(cch==4){
            orD.displayOrderDetails();
        }
        else
           break;
        }
        }
        else if(ch==5){
            while (true) {
                int cch;
                System.out.println("1.create");
                System.out.println("2.update");
                System.out.println("3. delete");
                System.out.println("4. show");
                System.out.println("Choose an option:");
                cch = sc.nextInt();
        if(cch==1){
            in.addInventory();
        }else if(cch==2){
           in.updateInventory();;
        }
        else if(cch==3){
           in.deleteInventory();
        }
        else if(cch==4){
           in.displayInventory();
        }
        else
           break;
        }
        }

     else
       break;



    }
}}
