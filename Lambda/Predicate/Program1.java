package Lambda.Predicate;

import java.util.List;
import java.util.stream.Collectors;

public class Program1 {
    
    public static void main(String[] args) {
        List<String> nomes = List.of("Ana", "João", "Mariana", "Pedro", "Felipe", "Gabriel");
        List<String> nomesFiltrados = nomes.stream().filter(x -> x.length() > 4).collect(Collectors.toList());

        nomesFiltrados.forEach(System.out::println);
    }
}
