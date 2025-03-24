package ExerciseCadastroProduto;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Quantos produtos você quer adicionar: ");
        int n = sc.nextInt();
        Loja loja = new Loja();
        for(int i = 0; i < n; i++){
            System.out.println("DADOS PRODUTO #" + (i+1));
            System.out.print("ID: ");
            Integer id = sc.nextInt();
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Preço: ");
            Double preco = sc.nextDouble();
            Produto produto = new Produto(id, nome, preco);
            loja.adicionarProdutos(produto);

        }

        loja.listarProdutos();
        
        sc.close();
    }
}
