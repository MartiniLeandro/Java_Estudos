package ExercisesAulas.exercisesLambda;

public class Program2 {
    interface operacao{
        int executar(int a, int b);
    };

    public static void main(String[] args) {
        operacao soma = (a,b) -> a + b;
        operacao subtracao = (a,b) -> a - b;
        operacao divisao = (a,b) -> a * b;
        operacao multiplicacao = (a,b) -> a / b;

        System.out.println(soma.executar(10,5));
        System.out.println(subtracao.executar(10,5));
        System.out.println(divisao.executar(10,5));
        System.out.println(multiplicacao.executar(10,5));

    }

}
