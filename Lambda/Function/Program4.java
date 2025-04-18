package Lambda.Function;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program4 {
    public static void main(String[] args) {
        List<String> nomes = List.of("Mariana", "Felipe", "Pedro");
        Function<String, Character> primeiraLetra = x -> x.charAt(0);
        List<Character> charNames = nomes.stream().map(primeiraLetra).collect(Collectors.toList());
        charNames.forEach(System.out::println);
    }
}
