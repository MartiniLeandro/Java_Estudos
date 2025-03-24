package ExercisePedido;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime momento = LocalDateTime.now();

        System.out.println("DADOS DO CLIENTE:");
        System.out.print("nome:");
        String nome = sc.nextLine();
        System.out.print("email:");
        String email = sc.next();
        Cliente cliente = new Cliente(nome,email);
        System.out.println("DADOS DO PEDIDO:");
        System.out.print("Status: ");
        String status = sc.next();
        Pedido pedido = new Pedido(momento, StatusPedido.valueOf(status));
        System.out.print("Quantos itens neste pedido: ");
        int qntdPedidos = sc.nextInt();
        for (int i = 0; i < qntdPedidos; i++){
            System.out.println("DADOS DO " + (i+1) + " ITEM:");
            System.out.print("Nome produto: ");
            String nomeProduto = sc.next();
            System.out.print("Preço produto: ");
            Double preco = sc.nextDouble();
            System.out.print("Quantidade: ");
            Integer quantidade = sc.nextInt();
            Produto produto = new Produto(nomeProduto, preco);
            ItemPedido itemPedido = new ItemPedido(quantidade, preco, produto);
            pedido.addItem(itemPedido);

        }
        System.out.println("DETALHES PEDIDO: ");
        System.out.println("Momento do pedido: " + pedido.getMomento());
        System.out.println("Status do pedido: " + pedido.getStatus());
        System.out.println("Cliente: " + cliente.getNome() + " - " + cliente.getEmail());
        System.out.println("ITENS PEDIDOS:");
        System.out.println(pedido);
        
        
        sc.close();
    
    
    }
        
}
