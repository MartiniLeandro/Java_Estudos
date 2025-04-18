package Lambda.Predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program4 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 6, 9, 12, 15, 18);
        Predicate<Integer> filtragem1 = x -> x > 10;
        Predicate<Integer> filtragem2 = x -> x % 3 == 0;
        List<Integer> numerosFiltrados = numeros.stream().filter(filtragem1.and(filtragem2)).collect(Collectors.toList());
        numerosFiltrados.forEach(System.out::println);

    }
}
