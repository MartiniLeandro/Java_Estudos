package ExerciseGestãoBiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGestaoBiblioteca {
    public static List<Livro> cadastroLivro(Scanner sc) {
        List<Livro> livros = new ArrayList<>();

        System.out.print("Quantos livros deseja ser cadastrado: ");
        Integer numeroLivros = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numeroLivros; i++) {
            System.out.print("Digite o título do livro #" + (i+1) + ": ");
            String nomeLivro = sc.nextLine();
            
            System.out.print("Digite o autor do livro: ");
            String autorLivro = sc.nextLine();
            
            System.out.print("Digite o ano de publicação: ");
            Integer anoPublicado = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Status do livro (DISPONIVEL/EMPRESTADO): ");
            String statusLivro = sc.nextLine();
    
            livros.add(new Livro(nomeLivro, autorLivro, anoPublicado, StatusLivro.valueOf(statusLivro)));
            
            System.out.println("LIVRO CADASTRADO COM SUCESSO!!!\n");
        }
        return livros;
    }

    public static List<Pessoa> cadastroPessoa(Scanner sc) {
        List<Pessoa> pessoas = new ArrayList<>();
        System.out.print("Quantas pessoas deseja cadastrar: ");
        Integer numeroPessoas = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
    
        for (int i = 0; i < numeroPessoas; i++) {
            System.out.print("Nome pessoa #" + (i + 1) + ": ");
            String nome = sc.nextLine();
    
            System.out.print("Número ID: ");
            Integer id = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
    
            System.out.print("Limite de livros para alugar: ");
            Integer limiteLivros = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
    
            System.out.print("Aluno ou Professor (a/p): ");
            String AlunoProfessor = sc.nextLine();
            Character AlunoProfessorCaractere = AlunoProfessor.charAt(0);
    
            if (AlunoProfessorCaractere == 'a') {
                String aluno = "aluno";
                Pessoa pessoa = new Pessoa(nome, id, limiteLivros, aluno);
                pessoas.add(pessoa);
            } else {
                String professor = "professor";
                Pessoa pessoa = new Pessoa(nome, id, limiteLivros, professor);
                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }

    public static void EmprestimoLivro(Scanner sc, List<Pessoa> pessoas, List<Livro> livros){
        System.out.print("Digite o ID do usuário: ");
        Integer id = sc.nextInt();
        Pessoa pessoaEncontrada = null;
        for (Pessoa pessoa : pessoas) {
            if(id.equals(pessoa.getId())){
                pessoaEncontrada = pessoa;
            }else{
                System.out.println("ESTE ID NÃO EXISTE!!");
            }
        }
        System.out.print("Digite o título do livro a ser emprestado: ");
        String livroAlugadro = sc.next();
        for (Livro livro : livros) {
            if(livroAlugadro.equals(livro.getTitulo()) && livro.getStatus() == StatusLivro.DISPONIVEL){
                pessoaEncontrada.getLivrosAlugados().add(livroAlugadro);
                System.out.println("livro " + livroAlugadro + " emprestado para " + pessoaEncontrada.getNome());
                //System.out.println(pessoaEncontrada.getLivrosAlugados());
            }else if(livroAlugadro.equals(livro.getTitulo()) && livro.getStatus() == StatusLivro.EMPRESTADO){
                System.out.println("ESTE LIVRO NÃO ESTÁ DISPONÍVEL PARA ALUGAR NO MOMENTO!!");
            }else{
                System.out.println("LIVRO NÃO CADASTRADO!!!");
            }
        }
        
    }
    
}
