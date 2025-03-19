package src.application;

import java.util.Scanner;

import src.classes.Carro;

public class CarroPoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carro carro;
        carro = new Carro();
        System.out.print("Marca do carro: ");
        carro.marca = sc.nextLine();
        System.out.print("Modelo do carro: ");
        carro.modelo = sc.nextLine();
        System.out.print("Ano do carro: ");
        carro.ano = sc.nextInt();
        System.out.print("Velocidade atual do carro: ");
        carro.velocidadeAtual = sc.nextDouble();
        System.out.printf("Marca: %S, Modelo: %S, Ano: %s, Velocidade Atual: %.2f%n", carro.marca, carro.modelo, carro.ano, carro.velocidadeAtual);
        System.out.print("Quanto você quer aumentar a velocidade do carro? ");
        double incremento = sc.nextDouble();
        carro.acelerar(incremento);
        System.out.println("A velocidade do carro agora é de: " + carro.velocidadeAtual);
        System.out.print("Quanto você quer diminuir a velocidade do carro? ");
        double frear = sc.nextDouble();
        carro.frear(frear);
        System.out.println("A velocidade do carro agora é de: " + carro.velocidadeAtual);
        carro.exibirInformacoes();
        
        sc.close();
    }
}
