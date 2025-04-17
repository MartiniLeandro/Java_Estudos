package ExercisesAulas.exercisesLambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 8, 12, 20, 3, 15));
        numeros.removeIf(x -> x<= 10);
        numeros.forEach(System.out::println);

    }
}
