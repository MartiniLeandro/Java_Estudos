package Lambda.Predicate;

import java.util.List;
import java.util.stream.Collectors;

public class Program3 {
    public static void main(String[] args) {
        List<String> nomes = List.of("Amanda", "Carlos", "Ana", "Bruno");
        List<String> nomesFiltrados = nomes.stream().filter(x -> x.charAt(0) != 'A').collect(Collectors.toList());
        nomesFiltrados.forEach(System.out::println);

    }
}
