package POO;

import java.util.Scanner;

import POO.classes.TemperatureConversor;

public class TemperatureConversorPoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma temperatura em Celsius: ");
        double tempC = sc.nextDouble();
        double tempConvertida = TemperatureConversor.celsiusParaFahrenheit(tempC);
        System.out.println("A temperatura convertida em F é de: " + tempConvertida);
        sc.close();
    }
}
