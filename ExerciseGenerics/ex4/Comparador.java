package ExerciseGenerics.ex4;

import java.util.List;

public class Comparador {
    public static <T extends Comparable<T>> T maiorDaLista(List<T> lista){
        T maiorValor = lista.get(0);
        for (T valor : lista) {
            if(valor.compareTo(maiorValor) > 0){
                maiorValor = valor;
            }
        }
        return maiorValor;
    }
}
