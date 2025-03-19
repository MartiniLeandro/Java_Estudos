package POO;

import java.util.Scanner;

import POO.classes.ContaBancaria;

public class ContaBancariaPoo {
    public static void main(String[] args) {
        ContaBancaria conta;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número da conta: ");
        int numeroConta = sc.nextInt();
        System.out.print("Digite o titular da conta: ");
        String titularConta = sc.next();
        System.out.print("Deseja fazer um depósito inicial(y/n): ");
        char depositoInicial = sc.next().charAt(0);
        if(depositoInicial == 'y'){
            System.out.print("Valor do depósito inicial: ");
            double valorDepositoInicial = sc.nextDouble();
            conta = new ContaBancaria(numeroConta, titularConta, valorDepositoInicial);
        }else {
            conta = new ContaBancaria(numeroConta, titularConta);
        }
        System.out.println("Informações da conta");
        System.out.println(conta);
        System.out.println();

        System.err.print("Faça um depósito: ");
        double deposito = sc.nextDouble();
        conta.deposito(deposito);
        System.out.println("Informações da conta:");
        System.out.println(conta);
        System.out.println();

        System.err.print("Faça um saque: ");
        double saque = sc.nextDouble();
        conta.saque(saque);
        System.out.println("Informações da conta");
        System.out.println(conta);
        System.out.println();







        sc.close();
    }
}
