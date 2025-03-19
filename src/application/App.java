package src.application;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double x;
        int y;
        String z;
        x = sc.nextDouble();
        y = sc.nextInt();
        z = sc.nextLine();
        System.out.println("Voce digitou estes codigos:");
        System.out.printf("%.2f%n", x);
        System.out.println(y);
        System.out.println(z);


        sc.close();


    }
    
}