package ExerciseContaExcecoes;


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("DADOS DA CONTA");
        System.out.print("Numero: ");
        Integer numero = sc.nextInt();
        System.out.print("Titular: ");
        String titular = sc.next();
        System.out.print("Saldo inicial: ");
        Double saldo = sc.nextDouble();
        System.out.print("Limite de saque: ");
        Double limiteSaque = sc.nextDouble();
        System.out.println();
        Conta conta = new Conta(numero, titular, saldo, limiteSaque);
        System.out.print("Digite o valor do saque: ");
        Double saque = sc.nextDouble();
        try{
            conta.saque(saque);
            System.out.print("Novo saldo: " + conta.getSaldo());

        }catch (ExcecaoConta e){
            System.out.println("Erro de saque: " + e.getMessage());
        }
        
        
        sc.close();
    }
}
