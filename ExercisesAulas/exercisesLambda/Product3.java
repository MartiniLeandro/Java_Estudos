package ExercisesAulas.exercisesLambda;

public class Product3 {
    interface Mensagem{
        void nome(String nome);
    }
    public static void main(String[] args) {
        Mensagem saudacaoNome = (nome) -> System.out.println("Olá, " + nome);
        saudacaoNome.nome("Leandro");
    }
}
