package ExerciseGestãoBiblioteca;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Livro> livros = SistemaGestaoBiblioteca.cadastroLivro(sc);
        List<Pessoa> pessoas = SistemaGestaoBiblioteca.cadastroPessoa(sc);
        System.out.println(livros);
        System.out.println(pessoas);



        
        sc.close();
    }
}
