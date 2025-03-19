package src.application;

import java.util.Scanner;

import src.classes.Estudante;

public class EstudantePoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Estudante estudante;
        estudante = new Estudante();
        System.out.print("Nome: ");
        estudante.nome = sc.nextLine();
        System.out.print("Nota 1: ");
        estudante.nota1 = sc.nextDouble();
        System.out.print("Nota 2: ");
        estudante.nota2 = sc.nextDouble();
        System.out.print("Nota 3: ");
        estudante.nota3 = sc.nextDouble();
        estudante.passOrFailed();


        sc.close();
    }
}
