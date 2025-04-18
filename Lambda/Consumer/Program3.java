package Lambda.Consumer;

import java.util.List;
import java.util.function.Consumer;

public class Program3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3,6,9,12);
        Consumer<Integer> numbersPlus10 = x -> System.out.println(x + 10);
        System.out.println();
        numbers.forEach(numbersPlus10);
    }
}
