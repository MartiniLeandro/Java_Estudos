package Lambda.Function;

import java.util.List;
import java.util.stream.Collectors;

public class Program3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3,5,7);
        List<Integer> numbersQuadrado = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        numbersQuadrado.forEach(System.out::println);
    }
    
}
