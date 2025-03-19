package POO.vetores;

import java.util.Scanner;

import POO.classes.ProvasClass;


public class Provas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantas provas você fez: ");
        int numeroProvas = sc.nextInt();
        ProvasClass[] provas = new ProvasClass[numeroProvas];
        for(int i = 0; i < provas.length; i++){
            System.out.print("Quanto você tirou na prova " + (i + 1) + ": ");
            double notaProva = sc.nextDouble();
            provas[i] = new ProvasClass(notaProva);
        }

        double somaNotas = 0;
        for(int i = 0; i < provas.length; i++){
            somaNotas += provas[i].getNotaProva();
        }

        double media = somaNotas / provas.length;
        System.out.println("A sua média ficou de: " + media);

        sc.close();
    }
}
