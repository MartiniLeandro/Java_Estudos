package ExerciseGenerics.ex7;

public class Comparador {
    public static <T> boolean comparar(T valor1, T valor2){
        if (valor1.equals(valor2)) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(comparar("teste", "teste"));
        System.out.println(comparar(20, "20"));
    }
}
