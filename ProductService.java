package MenuService;

import java.util.Scanner;
import Dao.ProductDao;
import exception.InvalidDataException;
import model.Products;

public class ProductService {
    Scanner sc;
    ProductDao pdao;

    public ProductService() {
        sc = new Scanner(System.in);
        pdao = new ProductDao();
    }

   public void addProduct() {
    Products p = new Products();
    System.out.println("Enter product ID:");
    p.setProductID(sc.nextInt());
    sc.nextLine(); // Consume newline
    System.out.println("Enter product name:");
    p.setProductName(sc.nextLine());
    System.out.println("Enter product description:");
    p.setDescription(sc.nextLine());
    System.out.println("Enter product price:");
    double price = sc.nextDouble();
    try {
        p.setPrice(price);
        pdao.add(p);
    } catch (InvalidDataException e) {
        System.out.println(e.getMessage());
    }
}


    public void updateProduct() {
        System.out.println("Enter product ID:");
        int productID = sc.nextInt();
        System.out.println("Enter new price:");
        double price = sc.nextDouble();
        pdao.update(productID, price);
    }

    public void deleteProduct() {
        System.out.println("Enter product ID:");
        int productID = sc.nextInt();
        pdao.delete(productID);
    }

    public void displayProducts() {
        pdao.show();
    }
}
