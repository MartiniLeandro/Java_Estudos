package ExerciseGenerics.ex6;

public class Arrays {
    public static <T> void imprimirArray(T[] array){
        for (T t : array) {
            System.out.println(t);
        }
    }
    
    
    public static void main(String[] args) {
        String[] array = {"teste1", "teste2", "teste3", "teste4"};
        imprimirArray(array);
    }
}
