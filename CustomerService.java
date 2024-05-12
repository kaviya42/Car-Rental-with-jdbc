package MenuService;

import java.util.Scanner;

import Dao.CustomerDao;
import model.Customers;
import exception.*;

public class CustomerService {

    Scanner sc;
    CustomerDao cdao;

    public CustomerService() {
        sc = new Scanner(System.in);
        cdao = new CustomerDao();
    }

    public void addCustomer() {
        Customers c = new Customers();
        System.out.println("Enter customer ID:");
        c.setCustomerID(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter first name:");
        c.setFirstName(sc.nextLine());
        System.out.println("Enter last name:");
        c.setLastName(sc.nextLine());
        System.out.println("Enter email:");
        try {
            c.setEmail(sc.nextLine());
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Enter phone:");
        c.setPhone(sc.nextLine());
        System.out.println("Enter address:");
        c.setAddress(sc.nextLine());
        cdao.add(c);
    }

    public void updateCustomer() {
        Customers c = new Customers();
        System.out.println("Enter customer ID:");
        c.setCustomerID(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter new email:");
        String email = sc.nextLine();
        System.out.println("Enter new phone:");
        String phone = sc.nextLine();
        System.out.println("Enter new address:");
        String address = sc.nextLine();
        cdao.update(c.getCustomerID(), email, phone, address);
    }

    public void deleteCustomer() {
        System.out.println("Enter customer ID:");
        int customerID = sc.nextInt();
        cdao.delete(customerID);
    }

    public void displayCustomers() {
        cdao.show();
    }

}