package ExerciseSet2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Set<Integer> alunos = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos há no curso A: ");
        Integer n = sc.nextInt();
        for(int i = 0; i < n; i++){
            Integer numberAluno = sc.nextInt();
            alunos.add(numberAluno);
        }
        System.out.print("Quantos alunos há no curso B: ");
        Integer j = sc.nextInt();
        for(int i = 0; i < j; i++){
            Integer numberAluno = sc.nextInt();
            alunos.add(numberAluno);
        }
        System.out.print("Quantos alunos há no curso C: ");
        Integer k = sc.nextInt();
        for(int i = 0; i < k; i++){
            Integer numberAluno = sc.nextInt();
            alunos.add(numberAluno);
        }

        System.out.println("Total de estudantes: " + alunos.size());

        sc.close();

    }
}
