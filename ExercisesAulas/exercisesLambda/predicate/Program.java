package ExercisesAulas.exercisesLambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(Arrays.asList("Ana", "Carlos", "Amanda", "Felipe"));
        nomes.removeIf(x -> x.charAt(0) == 'A');
        nomes.forEach(System.out::println);

    }
}
