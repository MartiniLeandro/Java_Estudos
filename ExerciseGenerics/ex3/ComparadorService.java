package ExerciseGenerics.ex3;


public class ComparadorService {
    public static <T extends Comparable<T>> T maiorValor(T valor1, T valor2){
        if(valor1.compareTo(valor2) > 0){
            return valor1;
        }else{
            return valor2;
        }
    }
}
