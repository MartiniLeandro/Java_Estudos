package ExercisesAulas.exercisesLambda;

public class Program {
    
        @FunctionalInterface
        interface Saudacao{
            void saudar();
        }
    public static void main(String[] args) {
       Saudacao saudacao = () -> {
        System.out.println();
        System.out.println("SAUDAÇÃO ATIVADA!!!");
       };

       saudacao.saudar();
    }
}
