package ExerciseGenerics.ex2;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        mostrarDois("Oi", 123);
        mostrarDois(10.5, true); 
    }

    
    public static <T> void mostrarDois(T valor1, T valor2){
        List<T> lista = new ArrayList<>();

        lista.add(valor1);
        lista.add(valor2);
        for (T t : lista) {
            System.out.print(t + ", ");
        }
    }
}
