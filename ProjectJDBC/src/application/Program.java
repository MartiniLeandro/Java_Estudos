package application;

import java.util.Date;

import entities.Department;
import entities.Seller;

public class Program {
    public static void main(String[] args) {
        Department dp = new Department(1, "books");
        System.out.println(dp);
        Seller sl = new Seller(21, "bob", "bob@gmail.com", new Date(), 3000.0, dp);
        System.out.println(sl);
    }
    
}
