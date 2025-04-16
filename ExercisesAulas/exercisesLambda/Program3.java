package ExercisesAulas.exercisesLambda;

public class Program3 {
    interface Verificador{
        boolean MaiorDeIdade(int idade);
    }

    public static void main(String[] args) {
        Verificador idade1 = (idade) -> {
            if(idade >=  18){
                return true;
            }else{
                return false;
            }
        };

        System.out.println(idade1.MaiorDeIdade(12));

    }
}
