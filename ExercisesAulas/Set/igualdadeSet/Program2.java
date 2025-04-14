package ExercisesAulas.Set.igualdadeSet;

import java.util.Set;
import java.util.TreeSet;

public class Program2 {
    public static void main(String[] args) {
        Set<Product> set = new TreeSet<>();

        set.add(new Product("tv", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));

        for (Product product : set) {
            System.out.println(product);
        }
    }
}
