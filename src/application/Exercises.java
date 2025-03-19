package src.application;
import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double valorCompra, valorRecebido, troco;
        valorCompra = sc.nextDouble(); 
        valorRecebido = sc.nextDouble();
        troco = FunctionTroco(valorCompra,valorRecebido);
        System.out.printf("O valor da compra foi %.2f, o valor recebido foi %.2f, e o troco é de %.2f", valorCompra, valorRecebido, troco);
         

        sc.close();
    }

    public static double FunctionTroco(double compra, double recebido){
        double troco = recebido - compra;
        return troco;
    }
}
