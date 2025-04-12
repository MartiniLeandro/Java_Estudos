package ExercisesAulas.generiscDelimitados2;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
    List<Pessoa> pessoas = new ArrayList<>();
    pessoas.add(new Pessoa("João", 25));
    pessoas.add(new Pessoa("Maria", 32));
    pessoas.add(new Pessoa("Ana", 28));

    Pessoa maisVelha = Comparador.maxIdade(pessoas);
    System.out.println("Pessoa mais velha: " + maisVelha);
}
}
