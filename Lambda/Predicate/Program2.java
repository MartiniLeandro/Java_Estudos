package Lambda.Predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program2 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(-3, -1, 0, 2, 4);
        Predicate<Integer> numerosInteiros = x -> x >= 0;
        List<Integer> numerosFiltrados = numeros.stream().filter(numerosInteiros).collect(Collectors.toList());
        
        System.out.println();
        numerosFiltrados.forEach(System.out::println);
    }


}
