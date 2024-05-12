package MenuService;

import java.util.Scanner;
import Dao.OrderDetailsDao;
import model.OrderDetails;
import model.Orders;
import model.Products;
import exception.*;

public class OrderDetailsService {
    Scanner sc;
    OrderDetailsDao oddao;

    public OrderDetailsService() {
        sc = new Scanner(System.in);
        oddao = new OrderDetailsDao();
    }

    public void addOrderDetail() {
        OrderDetails od = new OrderDetails();
        try {
            System.out.println("Enter order detail ID:");
            od.setOrderDetailID(sc.nextInt());
            System.out.println("Enter order ID:");
            Orders o = new Orders();
            o.setOrderID(sc.nextInt());
            od.setOrder(o);
            System.out.println("Enter product ID:");
            Products p = new Products();
            p.setProductID(sc.nextInt());
            od.setProduct(p);
            System.out.println("Enter quantity:");
            od.setQuantity(sc.nextInt());
            oddao.add(od);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateOrderDetails() {
        System.out.println("Enter order detail ID:");
        int orderDetailID = sc.nextInt();
        System.out.println("Enter new quantity:");
        int newQuantity = sc.nextInt();
        oddao.update(orderDetailID, newQuantity);
    }

    public void deleteOrderDetails() {
        System.out.println("Enter order detail ID:");
        int orderDetailID = sc.nextInt();
        oddao.delete(orderDetailID);
    }

    public void displayOrderDetails() {
        oddao.show();
    }

}
