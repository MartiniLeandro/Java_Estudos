package ExerciseGestãoEscolar;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("==== SISTEMA DE GESTÃO ESCOLAR ====");
        System.out.println();
        System.out.print("Quantos alunos você quer cadastrar: ");
        Integer numeroAlunos = sc.nextInt();
        for(int i = 0; i < numeroAlunos; i++){
            System.out.println("===== DADOS DO ALUNO #" + (i+1) + " ====");
            System.out.print("Nome do aluno: ");
            String nome = sc.nextLine();
            System.out.print("Idade do aluno");

        }
        
        sc.close();
    }
}
