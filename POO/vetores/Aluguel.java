package POO.vetores;

import java.util.Scanner;

import POO.classes.AluguelClass;

public class Aluguel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AluguelClass[] quartos = new AluguelClass[10];
        System.out.print("Quantos quartos serão alugados(1/10): ");
        int quartosAlugados = sc.nextInt();
        for(int i = 0; i < quartosAlugados; i++){
            System.out.println("Aluguel #" + (i+1));
            System.out.print("Nome: ");
            String nome = sc.next();
            sc.nextLine();
            System.out.print("Email: ");
            String email = sc.next();
            sc.nextLine();
            System.out.print("Quarto: ");
            int numeroQuarto = sc.nextInt();
            AluguelClass reservaQuarto = new AluguelClass(nome, email, numeroQuarto);
            quartos[numeroQuarto] = reservaQuarto;
        }
        System.out.println("Quartos ocupados");
        for(int i = 0; i < quartos.length; i++){
            if(quartos[i] != null){
                System.out.println(quartos[i]);
            };
        }

        
        sc.close();
    }
}
