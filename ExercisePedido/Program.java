package ExercisePedido;

import java.time.LocalDateTime;
import java.util.Scanner;

import ExercisePedido.services.ClienteService;
import ExercisePedido.services.PedidoService;
import ExercisePedido.services.ProdutoService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDateTime momento = LocalDateTime.now();
        ClienteService clienteService = new ClienteService();
        PedidoService pedidoService = new PedidoService();
        ProdutoService produtoService = new ProdutoService();

        System.out.println("DADOS DO CLIENTE:");
        System.out.print("nome:");
        String nome = sc.nextLine();
        System.out.print("email:");
        String email = sc.next();
        Cliente cliente = clienteService.addCliente(nome, email);
        System.out.println("DADOS DO PEDIDO:");
        System.out.print("Status: ");
        String status = sc.next();
        pedidoService.addPedido(momento, StatusPedido.valueOf(status));
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
            Produto produto = produtoService.addProduto(nomeProduto, preco);
            ItemPedido itemPedido = new ItemPedido(quantidade, preco, produto);
            pedidoService.addItem(itemPedido);

        }
        System.out.println("DETALHES PEDIDO: ");
        System.out.println("Momento do pedido: " + pedidoService.getMomento());
        System.out.println("Status do pedido: " + pedidoService.getStatus());
        System.out.println("Cliente: " + cliente.getNome() + " - " + cliente.getEmail());
        System.out.println("ITENS PEDIDOS:");
        System.out.println(pedidoService);
        
        
        sc.close();
    
    
    }
        
}
