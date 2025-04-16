package ExercisesAulas.functionsToFunctions;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Tv", 900.00));
        products.add(new Product("mouse", 50.00));
        products.add(new Product("Tablet", 350.00));
        products.add(new Product("HD case", 80.00));

        ProductService ps = new ProductService();
        double soma = ps.filteredSum(products, p -> p.getNome().charAt(0) == 'T');
        System.out.println("Soma: " + soma);





    }
}
