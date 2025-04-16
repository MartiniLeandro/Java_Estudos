package ExercisesAulas.exercisesLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExercise {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
            products.add(new Product("tv", 900.00));
            products.add(new Product("mouse", 50.00));
            products.add(new Product("tablet", 350.00));
            products.add(new Product("hd case", 80.00));

            Consumer<Product> produtos = p -> p.setValor(p.getValor() * 1.1);

            //products.forEach(p -> p.setValor(p.getValor() *  1.1));
            //products.forEach(new ProductConsumer());
            //products.forEach(Product::staticConsumer);
            //products.forEach(Product::NoStaticConsumer);
            products.forEach(produtos);
            
            products.forEach(System.out::println);
    }
}
