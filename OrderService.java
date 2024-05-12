package MenuService;

import java.util.Scanner;

import Dao.OrderDao;
import model.Customers;
import model.Orders;

public class OrderService {
    Scanner sc;
    OrderDao odao;

    public OrderService() {
        sc = new Scanner(System.in);
        odao = new OrderDao();
    }

    public void addOrder() {
        Orders o = new Orders();
        System.out.println("Enter order ID:");
        o.setOrderID(sc.nextInt());
        System.out.println("Enter customer ID:");
        Customers c = new Customers();
        c.setCustomerID(sc.nextInt());
        o.setCustomer(c);
        sc.nextLine();
        System.out.println("Enter order date:");
        o.setOrderDate(sc.nextLine());
        System.out.println("Enter total amount:");
        o.setTotalAmount(sc.nextDouble());
        odao.add(o);
    }

    public void updateOrder() {
        System.out.println("Enter order ID:");
        int orderID = sc.nextInt();
        System.out.println("Enter new total amount:");
        double totalAmount = sc.nextDouble();
        odao.update(orderID, totalAmount);
    }

    public void deleteOrder() {
        System.out.println("Enter order ID:");
        int orderID = sc.nextInt();
        odao.delete(orderID);
    }

    public void displayOrders() {
        odao.show();
    }

}

