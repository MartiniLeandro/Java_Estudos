package ExercisesAulas.exercisesLambda.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Program2 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10,20,30,40,50);
        Consumer<Integer> numerosDupilicados = x -> System.out.println(x * 2);
        numeros.forEach(numerosDupilicados);
    }
}
             