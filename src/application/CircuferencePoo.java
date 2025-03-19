package src.application;

import java.util.Scanner;

import src.classes.Circuference;

public class CircuferencePoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Radius: ");
        double radius = sc.nextDouble();
        double c = Circuference.circumference(radius);
        double v = Circuference.volume(radius);
        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI: %.2f%n", Circuference.PI);



        sc.close();
    }
}
