package src.application;

import java.util.Scanner;

import src.classes.RealDolar;

public class RealDolarPoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cotação do dolar: ");
        double dolar = sc.nextDouble();
        System.out.print("Quantos doláres você quer comprar: ");
        double dolarComprado = sc.nextDouble();
        double valorTotal = RealDolar.valorGasto(dolar,dolarComprado);
        System.out.println("Valor total gasto: " + valorTotal);
        sc.close();
    }
}
