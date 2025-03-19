package src.application;
import java.util.Scanner;

public class Condicional {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um número");
        int number1 = teclado.nextInt();
        ShowNumber(number1);
        teclado.close();
    }

    public static void ShowNumber(int num){
        System.out.println("O numero escolhido é " + num);
    }
}
