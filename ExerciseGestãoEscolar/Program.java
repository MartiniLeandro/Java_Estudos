package ExerciseGestãoEscolar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> alunos = new ArrayList<>();
        List<Pessoa> professores = new ArrayList<>();

        System.out.println("==== SISTEMA DE GESTÃO ESCOLAR ====");
        System.out.println();
        try{
            System.out.print("Quantos alunos você quer cadastrar: ");
            int numeroAlunos = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha
            
            for (int i = 0; i < numeroAlunos; i++) {
                System.out.println();
                System.out.println("===== DADOS DO ALUNO #" + (i + 1) + " =====");
                System.out.print("Nome do aluno: ");
                String nome = sc.nextLine();
                System.out.print("Email do aluno: ");
                String email = sc.nextLine();
                System.out.print("CPF do aluno: ");
                Long cpf = sc.nextLong();
                System.out.print("Matrícula do aluno: ");
                Integer matricula = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha
    
                Aluno aluno = new Aluno(nome, email, cpf, matricula);
                Boletim boletim = new Boletim();
    
                System.out.print("Quantidade de notas no boletim: ");
                Integer numeroNotas = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha
    
                for (int j = 0; j < numeroNotas; j++) {
                    System.out.print("Nota #" + (j + 1) + ": ");
                    Double nota = sc.nextDouble();
                    boletim.addNota(nota);
                    sc.nextLine(); // Consumir quebra de linha extra
                }
                aluno.setBoletim(boletim);
    
                alunos.add(aluno);
            }
    
            System.out.println();
            System.out.print("Quantos professores você quer cadastrar: ");
            int numeroProfessores = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha
    
            for (int i = 0; i < numeroProfessores; i++) {
                System.out.println();
                System.out.println("===== DADOS DO PROFESSOR #" + (i + 1) + " =====");
                System.out.print("Nome do professor: ");
                String nome = sc.nextLine();
                System.out.print("Email do professor: ");
                String email = sc.nextLine();
                System.out.print("CPF do professor: ");
                Long cpf = sc.nextLong();
                System.out.print("Salário do professor: ");
                double salario = sc.nextDouble();
                sc.nextLine(); // Consumir quebra de linha
    
                Professor professor = new Professor(nome, email, cpf, salario);
    
                System.out.print("Quantas matérias ministradas: ");
                int numeroMaterias = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha
    
                for (int j = 0; j < numeroMaterias; j++) {
                    System.out.print("Matéria #" + (j + 1) + ": ");
                    String materia = sc.nextLine();
                    professor.addDisciplinas(materia);
                }
    
                professores.add(professor);
            }
    
            System.out.println();
            System.out.println("=== ALUNOS CADASTRADOS ===");
            System.out.println(alunos);
            
            System.out.println();
            System.out.println("=== PROFESSORES CADASTRADOS ===");
            System.out.println(professores);

        }catch(ExcecaoSistemaEscolar e){
            System.out.println(e.getMessage());
        }catch(InputMismatchException e){
            System.out.println("VALOR DA DADO INVÁLIDO!!!");
        }


        sc.close();
    }
}
