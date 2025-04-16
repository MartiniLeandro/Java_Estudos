package ExercisesAulas.exercisesLambda;

import java.util.function.Function;

public class ProductFunction implements Function<Product,String>{

    @Override
    public String apply(Product p) {
        return p.getNome().toUpperCase();
    }
    
}
