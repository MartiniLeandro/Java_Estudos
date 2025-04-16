package ExercisesAulas.exercisesLambda;

import java.util.function.Consumer;

public class ProductConsumer implements Consumer<Product>{

    @Override
    public void accept(Product p) {
        p.setValor(p.getValor() * 1.10);
    }
    
}
