package ExercisesAulas.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("tv", 900.0));
        list.add(new Product("notebook", 4000.0));
        list.add(new Product("mouse", 220.0));
        
        Comparator<Product> comp = (p1,p2) -> {
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        };

        list.sort(comp);

        for (Product product : list) {
            System.out.println(product);
        }
    }
}
