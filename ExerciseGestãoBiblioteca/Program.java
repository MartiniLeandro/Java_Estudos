package ExerciseGestãoBiblioteca;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== CADASTRANDO LIVROS ===");
        List<Livro> livros = SistemaGestaoBiblioteca.cadastroLivro(sc);
        System.out.println("=== CADASTRANDO PESSOAS ===");
        List<Pessoa> pessoas = SistemaGestaoBiblioteca.cadastroPessoa(sc);
        System.out.println(livros);
        System.out.println(pessoas);
        System.out.println("=== EMPRÉSTIMO LIVROS ===");
        SistemaGestaoBiblioteca.EmprestimoLivro(sc,pessoas,livros);



        
        sc.close();
    }
}
