package ExerciseProdutos2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por nome");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    produtoService.adicionarProduto(nome, preco);
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("Produtos cadastrados:");
                    for (Produto p : produtoService.listarProdutos()) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Nome do produto a buscar: ");
                    String nomeBusca = scanner.nextLine();
                    Produto encontrado = produtoService.buscarProdutoPorNome(nomeBusca);
                    if (encontrado != null) {
                        System.out.println("Produto encontrado: " + encontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
