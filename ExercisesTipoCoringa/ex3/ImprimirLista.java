package ExercisesTipoCoringa.ex3;

import java.util.Arrays;
import java.util.List;

public class ImprimirLista {
    public static void imprimir(List<?> lista){
        for (Object object : lista) {
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("teste", "teste2", "teste3");
        List<Integer> list2 = Arrays.asList(1,2,3,4,56);
        List<Double> list3 = Arrays.asList(1.4,2.0,3.21,4.0123,56.123);
        imprimir(list1);
        imprimir(list2);
        imprimir(list3);
    }
}
