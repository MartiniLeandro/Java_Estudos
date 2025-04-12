package ExerciseGenerics.ex4;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Double> valores = List.of(2.5, 3.9, 1.0);
        Double maior = Comparador.maiorDaLista(valores); // Saída: 3.9
        System.out.println(maior);
    }
    
}
