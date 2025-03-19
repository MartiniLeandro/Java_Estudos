package POO;

import java.util.Scanner;

import POO.classes.SistemaEnergia;

public class SistemaEnergiaPoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaEnergia sistemaEnergia;
        System.out.print("Digite o número da conta: ");
        int numeroConta = sc.nextInt();
        System.out.print("Digite o titular da conta: ");
        String titularConta = sc.next();
        System.out.print("Digite o consumo inicial: ");
        int consumoInicial = sc.nextInt();
        if(consumoInicial == 0){
            sistemaEnergia = new SistemaEnergia(numeroConta, titularConta);
        }else{
            sistemaEnergia = new SistemaEnergia(numeroConta, titularConta,consumoInicial);
        }
        System.out.print("Adicionar consumo de energia: ");
        int consumoEnergia = sc.nextInt();
        sistemaEnergia.adicionarConsumo(consumoEnergia);
        System.out.print("Digite o valor da tarifa de KWH: ");
        double valorTarifa = sc.nextDouble();
        sistemaEnergia.calcularValorTarifa(valorTarifa);

        

        
        
        sc.close();
    }
}
