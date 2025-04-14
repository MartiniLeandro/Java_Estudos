package ExercisesTipoCoringa.ex1;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(3,4,5,6,7);
        List<Double> myDouble = Arrays.asList(3.9,4.5,5.2,6.9,7.7);

        double valorSoma = somaList(myInts);
        printSoma(valorSoma);
        valorSoma = somaList(myDouble);
        printSoma(valorSoma);
    }

    public static double somaList(List<? extends Number> list){
        double soma = 0.0;
        for (Number number : list) {
            soma += number.doubleValue();
        }
        return soma;
    }

    public static void printSoma(double valor){
        System.out.println("Valor da soma: " + valor);
    }


}
