package ExercisesAulas.map;

import java.util.HashMap;
import java.util.Map;

public class Program2 {
    public static void main(String[] args) {
        Map<Product, Double> products = new HashMap<>();

        Product p1 = new Product("tv", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("tablet", 400.0);

        products.put(p1, 1000.0);
        products.put(p2, 2000.0);
        products.put(p3, 1500.0);

        Product ps = new Product("tv", 900.0);

        System.out.println("Contains 'ps' key: " + products.containsKey(ps));
    }
}
