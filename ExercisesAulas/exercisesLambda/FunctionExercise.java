package ExercisesAulas.exercisesLambda;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExercise {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("tv", 900.00));
        products.add(new Product("mouse", 50.00));
        products.add(new Product("tablet", 350.00));
        products.add(new Product("hd case", 80.00));

        //Function<Product,String> nomes = p -> p.getNome().toUpperCase();

        List<String> names = products.stream().map(new ProductFunction()).collect(Collectors.toList());
        //List<String> names2 = products.stream().map(Product::staticFunction).collect(Collectors.toList());
        //List<String> names3 = products.stream().map(Product::NoStaticFunction).collect(Collectors.toList());
        //List<String> names4 = products.stream().map(x -> x.getNome().toUpperCase()).collect(Collectors.toList());
        //List<String> names5 = products.stream().map(nomes).collect(Collectors.toList());

        
        
        names.forEach(System.out::println);
    }
}
