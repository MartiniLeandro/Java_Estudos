package ExercisesTipoCoringa.ex2;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void adicionarInteiros(List<? super Integer> lista) {
        lista.add(10);
        lista.add(20);
        lista.add(30);
    }

    public static void main(String[] args) {
        List<Number> numeros = new ArrayList<>();
        adicionarInteiros(numeros);
        System.out.println(numeros);
    }

}
