package application;

import java.util.List;
import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {
    public static void main(String[] args) {
        
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("\n=== TEST 2: sellers findByDepartment ===");
        List<Seller> sellersByDepartment = sellerDao.findByDepartment(new Department(2, null));
        sellersByDepartment.forEach(System.out::println);
        System.out.println("\n=== TEST 3: FindAll Sellers ===");
        List<Seller> allSellers = sellerDao.findAll();
        allSellers.forEach(System.out::println);
    }
    
}
