package ExerciseGestãoBiblioteca;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("=== CADASTRANDO LIVROS ===");
            List<Livro> livros = SistemaGestaoBiblioteca.cadastroLivro(sc);
            System.out.println("=== CADASTRANDO PESSOAS ===");
            List<Pessoa> pessoas = SistemaGestaoBiblioteca.cadastroPessoa(sc);
            System.out.println(livros);
            System.out.println(pessoas);
            System.out.println("=== EMPRÉSTIMO LIVROS ===");
            SistemaGestaoBiblioteca.EmprestimoLivro(sc,pessoas,livros);
            System.out.println("=== DEVOLVER LIVROS ===");
            SistemaGestaoBiblioteca.devolverLivro(sc,pessoas,livros);
            System.out.println("=== LISTA DOS LIVROS ===");
            SistemaGestaoBiblioteca.listaLivros(livros);
            System.out.println("=== USUÁRIOS COM LIVROS ALUGADOS ===");
            SistemaGestaoBiblioteca.pessoasEmprestimo(pessoas);

        }catch(InputMismatchException e){
            System.out.println("Valor de caractere incorreto!!!");
        }
        


        
        sc.close();
    }
}
