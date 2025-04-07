package ExerciseCadastroProduto;

import java.util.Scanner;

import ExerciseCadastroProduto.services.ProductService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Loja loja = new Loja();
        ProductService service = new ProductService(loja);

        System.out.print("Quantos produtos você quer adicionar: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("DADOS PRODUTO #" + (i + 1));
            System.out.print("ID: ");
            Integer id = sc.nextInt();

            System.out.print("Nome: ");
            String nome = sc.next();

            System.out.print("Preço: ");
            Double preco = sc.nextDouble();

            service.cadastrarProduto(id, nome, preco);
        }

        System.out.println("\nProdutos cadastrados:");
        service.exibirProdutos();

        sc.close();
    }
}
