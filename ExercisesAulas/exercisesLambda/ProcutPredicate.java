package ExercisesAulas.exercisesLambda;

import java.util.function.Predicate;

public class ProcutPredicate implements Predicate<Product> {

    @Override
    public boolean test(Product p) {
        return p.getValor() >= 100;
    }
    
}
