package Lambda.Consumer;

import java.util.List;
import java.util.function.Consumer;

public class Program4 {
    public static void main(String[] args) {
        List<String> names = List.of("Ana", "Carlos", "Mariana");
        Consumer<String> printName = x -> System.out.println(x);
        Consumer<String> printLengthName = x -> System.out.println("Tamanho do name: " + x.length());
        System.out.println();
        names.forEach(printName.andThen(printLengthName));
    }
}
