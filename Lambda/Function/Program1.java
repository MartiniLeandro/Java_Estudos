package Lambda.Function;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2,4,6,8);
        Function<Integer, Integer> numbersDouble = x -> x *2;
        List<Integer> numerosDuplicados = numbers.stream().map(numbersDouble).collect(Collectors.toList());
        numerosDuplicados.forEach(System.out::println);

    }
}
