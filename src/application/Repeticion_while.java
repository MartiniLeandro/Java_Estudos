package src.application;
import java.util.Scanner;

public class Repeticion_while {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int soma = 0;
        while(number != 0){
            soma += number;
            number = sc.nextInt();
        }
        System.out.println("O valor da soma é: " + soma);
        sc.close();
    }
}
