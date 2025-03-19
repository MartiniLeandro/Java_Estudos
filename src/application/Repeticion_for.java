package src.application;
import java.util.Scanner;

public class Repeticion_for {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),soma = 0, number;
        for(int i=0; i <= n; i++ ){
            number = sc.nextInt();
            soma += number;
        }
        System.out.println("A soma dos números foi de: " + soma);
        
        sc.close();
    }
}
