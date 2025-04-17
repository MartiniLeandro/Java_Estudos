package ExercisesTipoCoringa.ex4;

import java.util.Arrays;
import java.util.List;

public class Soma {
    
    public static double somar(List<? extends Number> list){
        double soma = 0.0;
        for (Number number : list) {
            soma += number.doubleValue();
        }
        return soma;
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3,5,7,8);
        List<Double> list2 = Arrays.asList(8.9,7.2,5.3);
        System.out.println(somar(list1));
        System.out.println(somar(list2));
    }
}
