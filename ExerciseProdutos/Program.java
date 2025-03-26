package ExerciseProdutos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Produto> produtos = new ArrayList<>();
        System.out.print("Quantidade de produtos: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            System.out.println("DADOS PRODUTO #" + (i+1));
            System.out.print("Comum, Usado ou Importado(c/u/i): ");
            Character caractere = sc.next().charAt(0);
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Valor: ");
            Double valor = sc.nextDouble();
            if(caractere == 'i'){
                System.out.print("Taxa de alfândega: ");
                Double valorAlfandega = sc.nextDouble();
                Produto produto = new ProdutoImportado(nome, valor, valorAlfandega);
                produtos.add(produto);
            }else if(caractere == 'u'){
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Produto produto = new ProdutoUsado(nome, valor, data);
                produtos.add(produto);
            }else if(caractere == 'c'){
                Produto produto = new Produto(nome, valor);
                produtos.add(produto);
            }

            System.out.println("ETIQUETAS:");
            for (Produto produto : produtos) {
                System.out.println(produto.etiqueta());
            }
        }
        
        sc.close();
    }
}
