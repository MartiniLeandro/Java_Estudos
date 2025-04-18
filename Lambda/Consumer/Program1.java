package Lambda.Consumer;

import java.util.List;
import java.util.function.Consumer;

public class Program1 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -1, 0, 2, 4);
        Consumer<Integer> printNumbers = x -> System.out.println(x);
        System.out.println();
        numbers.forEach(printNumbers);
    }
}
