package ExerciseGestãoEscolar;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== SISTEMA DE GESTÃO ESCOLAR ====");
        System.out.println();
        try{
                
                List<Pessoa> alunos = SistemaEscolar.CadastroAluno(sc);
                List<Pessoa> professores = SistemaEscolar.cadastrarProfessor(sc);
    
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
