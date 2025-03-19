package POO.vetores;

import java.util.Scanner;

import POO.classes.Produtos;

public class ExTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quantas produtos você quer: ");
        int n = sc.nextInt();
        Produtos[] vect = new Produtos[n];
        for(int i = 0; i < n; i++){
            sc.nextLine();
            String nome = sc.nextLine();
            double valor = sc.nextDouble();
            vect[i] = new Produtos(nome, valor);
        }

        double soma = 0;
        for(int i = 0; i < n; i++){
            soma += vect[i].valor;
        }

        double avg = soma / n;

        System.out.println("O preço médio de todos produtos é " + avg);
        sc.close();
        
    }
}
