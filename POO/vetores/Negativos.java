package POO.vetores;

import java.util.Scanner;

public class Negativos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos números você vai digitar: ");
        int totalNumeros = sc.nextInt();
        int[] numeros = new int[totalNumeros];
        for(int i = 0; i < numeros.length; i++){
            System.out.print("Digite um número: ");
            int numero = sc.nextInt();
            numeros[i] = numero;
        }
        System.out.println("Numeros negativos:");
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] < 0 ){
                System.out.println(numeros[i]);
            }
        }

        sc.close();
    }
}
