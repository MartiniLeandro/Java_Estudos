package src.application;

import java.util.Scanner;

import src.classes.Retangle;

public class RetanglePoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Retangle retangle;

        retangle = new Retangle();
        System.err.print("Width retangle: ");
        retangle.width = sc.nextDouble();
        System.err.print("Height retangle: ");
        retangle.height = sc.nextDouble();

        System.err.println("O valor da área deste retângulo é: " + retangle.Area());
        System.err.println("O valor da perímetro deste retângulo é: " + retangle.Perimeter());
        System.err.println("O valor da diagonal deste retângulo é: " + retangle.Diagonal());


    
    
    sc.close();
    }
}
