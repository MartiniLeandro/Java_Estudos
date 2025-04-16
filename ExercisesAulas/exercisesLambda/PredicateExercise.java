package ExercisesAulas.exercisesLambda;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;

public class PredicateExercise {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("tv", 900.00));
        products.add(new Product("mouse", 50.00));
        products.add(new Product("tablet", 350.00));
        products.add(new Product("hd case", 80.00));

        //Predicate<Product> pred =  p -> p.getValor() > 100;

        //products.removeIf(new ProcutPredicate());
        //products.removeIf(Product::staticProductPredicate);
        //products.removeIf(Product::NoStaticProductPredicate);
        //products.removeIf(pred);
        products.removeIf(p -> p.getValor() > 100);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
