package application;

//import java.util.Date;
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
        //System.out.println("\n=== TEST 4: seller insert ===");
        //Seller newSeller = new Seller(8, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
        //sellerDao.insert(newSeller);
        System.out.println("Inserted!");
        System.out.println("\n=== TEST 5: update seller ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!!");
    }
    
}
