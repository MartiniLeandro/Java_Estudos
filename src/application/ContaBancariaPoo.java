package src.application;

import java.util.Scanner;

import src.classes.ContaBancaria;

public class ContaBancariaPoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria conta;
        conta = new ContaBancaria();
        System.out.print("Nome do titular: ");
        conta.titular = sc.nextLine();
        System.out.print("Saldo: ");
        conta.saldo = sc.nextDouble();
        System.out.print("Quanto você deseja depositar: ");
        double deposito = sc.nextDouble();
        conta.depositar(deposito);
        System.out.print("Quanto você deseja sacar: ");
        double saque = sc.nextDouble();
        conta.sacar(saque);
        conta.exibirSaldo();


        
        sc.close();
        
    }
}
