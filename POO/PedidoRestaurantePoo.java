package POO;

import java.util.Scanner;

import POO.classes.PedidoRestaurante;

public class PedidoRestaurantePoo {
    public static void main(String[] args) {
        PedidoRestaurante pedidoRestaurante;
        Scanner sc = new Scanner(System.in);
        System.err.print("Digite o número do pedido: ");
        int numeroPedido = sc.nextInt();
        System.err.print("Digite o nome do cliente: ");
        String cliente = sc.next();
        System.err.print("Digite o valor do primeiro item: ");
        double primeiroItem = sc.nextDouble();
        System.err.print("Digite o número do pedido: ");
        double segundoItem = sc.nextDouble();
        if(primeiroItem + segundoItem != 0){
            double valorTotal =  primeiroItem + segundoItem;
            pedidoRestaurante = new PedidoRestaurante(numeroPedido,cliente,valorTotal);
        }else{
            pedidoRestaurante = new PedidoRestaurante(numeroPedido,cliente);
        }
        System.err.print("Adicione o valor de outro pedido: ");
        double valor = sc.nextDouble();
        pedidoRestaurante.adicionarItem(valor);
        System.err.print("Deseja aplicar desconto (y/n): ");
        char desconto = sc.next().charAt(0);
        if(desconto == 'y'){
            System.err.print("Digite o percentual de desconto: ");
            double percentual = sc.nextDouble();
            pedidoRestaurante.aplicarDesconto(percentual);
        }
        System.out.println("Valor final do pedido: " + pedidoRestaurante.getValorTotal());


        
        sc.close();
    }
}
