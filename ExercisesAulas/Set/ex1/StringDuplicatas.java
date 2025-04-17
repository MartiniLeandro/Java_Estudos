package ExercisesAulas.Set.ex1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringDuplicatas {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Leandro", "Ana", "Felipe", "Leandro", "Ana", "João");
        Set<String> nomesUnicos = new HashSet<>(nomes);
        System.out.println(nomesUnicos);
        
    }
}
