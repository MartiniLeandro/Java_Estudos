package Lambda.Consumer;

import java.util.List;
import java.util.function.Consumer;

public class Program2 {
    public static void main(String[] args) {
        List<String> nomes = List.of("ana", "joao", "mariana", "pedro");
        Consumer<String> nomesMaiusculos = x -> System.out.println(x.toUpperCase());
        System.out.println();
        nomes.forEach(nomesMaiusculos);
    }
}
