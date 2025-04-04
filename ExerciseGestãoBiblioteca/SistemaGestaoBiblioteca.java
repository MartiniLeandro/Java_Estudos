package ExerciseGestãoBiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGestaoBiblioteca {
    public static List<Livro> cadastroLivro(Scanner sc) {
        List<Livro> livros = new ArrayList<>();

        System.out.print("Quantos livros deseja cadastrar? ");
        Integer numeroLivros = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        for (int i = 0; i < numeroLivros; i++) {
            System.out.println("\nCadastrando Livro #" + (i + 1));

            System.out.print("Título do livro: ");
            String nomeLivro = sc.nextLine();
            
            System.out.print("Autor do livro: ");
            String autorLivro = sc.nextLine();
            
            System.out.print("Ano de publicação: ");
            Integer anoPublicado = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
            
            System.out.print("Status do livro (DISPONIVEL/EMPRESTADO): ");
            String statusLivro = sc.nextLine();
    
            livros.add(new Livro(nomeLivro, autorLivro, anoPublicado, StatusLivro.valueOf(statusLivro)));
            
            System.out.println("Livro cadastrado com sucesso!\n");
        }
        return livros;
    }

    public static List<Pessoa> cadastroPessoa(Scanner sc) {
        List<Pessoa> pessoas = new ArrayList<>();   
        
        System.out.print("Quantas pessoas deseja cadastrar? ");
        Integer numeroPessoas = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
    
        for (int i = 0; i < numeroPessoas; i++) {
            System.out.println("\nCadastrando Pessoa #" + (i + 1));

            System.out.print("Nome: ");
            String nome = sc.nextLine();
    
            System.out.print("Número ID: ");
            Integer id = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
    
            System.out.print("Limite de livros para alugar: ");
            Integer limiteLivros = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
    
            System.out.print("Aluno ou Professor (a/p): ");
            String alunoProfessor = sc.nextLine();
            Character alunoProfessorCaractere = alunoProfessor.charAt(0);
    
            String tipo = (alunoProfessorCaractere == 'a') ? "Aluno" : "Professor";
            pessoas.add(new Pessoa(nome, id, limiteLivros, tipo));

            System.out.println("Pessoa cadastrada com sucesso!\n");
        }
        return pessoas;
    }

    public static void EmprestimoLivro(Scanner sc, List<Pessoa> pessoas, List<Livro> livros) {
        System.out.print("\nDigite o ID do usuário: ");
        Integer id = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
        
        Pessoa pessoaEncontrada = null;
        for (Pessoa pessoa : pessoas) {
            if (id.equals(pessoa.getId())) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada == null) {
            System.out.println("ID não encontrado!");
            return;
        }

        System.out.print("Digite o título do livro a ser emprestado: ");
        String livroAlugado = sc.nextLine();

        for (Livro livro : livros) {
            if (livroAlugado.equalsIgnoreCase(livro.getTitulo())) {
                if (livro.getStatus() == StatusLivro.DISPONIVEL) {
                    pessoaEncontrada.getLivrosAlugados().add(livroAlugado);
                    System.out.println("Livro \"" + livroAlugado + "\" emprestado para " + pessoaEncontrada.getNome());
                    livro.setStatus(StatusLivro.EMPRESTADO);
                } else {
                    System.out.println("O livro \"" + livroAlugado + "\" já está emprestado.");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado no sistema!");
    }

    public static void devolverLivro(Scanner sc, List<Pessoa> pessoas, List<Livro> livros) {
        System.out.print("\nDigite o ID do usuário: ");
        Integer id = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
        
        Pessoa pessoaBuscada = null;
        for (Pessoa pessoa : pessoas) {
            if (id.equals(pessoa.getId())) {
                pessoaBuscada = pessoa;
                break;
            }
        }

        if (pessoaBuscada == null) {
            System.out.println("ID não encontrado!");
            return;
        }

        System.out.print("Digite o título do livro a ser devolvido: ");
        String livroDevolvido = sc.nextLine();

        if (pessoaBuscada.getLivrosAlugados().contains(livroDevolvido)) {
            pessoaBuscada.getLivrosAlugados().remove(livroDevolvido);
            System.out.println("Livro \"" + livroDevolvido + "\" devolvido com sucesso!");
        } else {
            System.out.println(pessoaBuscada.getNome() + " não pegou esse livro!");
        }
    }

    public static void listaLivros(List<Livro> livros) {
        System.out.println("\nLista de livros cadastrados:");
        int ordem = 1;
        for (Livro livro : livros) {
            System.out.println(ordem + " - " + livro.getTitulo() + 
                " | Autor: " + livro.getAutor() + 
                " | Ano: " + livro.getAnoPublicado() + 
                " | Status: " + livro.getStatus());
            ordem++;
        }
    }

    public static void pessoasEmprestimo(List<Pessoa> pessoas){
        for (Pessoa pessoa : pessoas) {
            if (!pessoa.getLivrosAlugados().isEmpty()) {
                System.out.println(pessoa.getNome() + " pegou: " + pessoa.getLivrosAlugados());
            }
        }
    }
}
