package Lambda.Function;

import java.util.List;
import java.util.stream.Collectors;

public class Program2 {
    public static void main(String[] args) {
        List<String> names = List.of("ana", "bruno", "carlos");
        List<String> namesUpper = names.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        namesUpper.forEach(System.out::println);
    }
}
