package ExerciseNotasExcecoes;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nota: ");
        Double nota = sc.nextDouble();
        try{
            Aluno aluno = new Aluno(nome);
            aluno.setNota(nota);

            System.out.println("NOTA VÁLIDA!!");
        }catch(ExcecaoNota e ){
            System.out.println(e.getMessage());
        }
        
        sc.close();
    }
}
