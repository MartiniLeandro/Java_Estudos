package ExercisesAulas.exercisesLambda.consumer;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("leandro", "gabriel", "thiago");
        nomes.forEach(x -> System.out.println("Olá " + x + "! Seja bem vindo(a)"));
        
    }
}
