package src.application;

import java.util.Scanner;

import src.classes.Triangle;

public class ExTrianglePOO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double areaTrianguloX,areaTrianguloY;
        Triangle x,y;
        x = new Triangle();
        y = new Triangle();
        System.err.println("Digite os valores dos lados do triangulo X:");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();
        areaTrianguloX = x.area();
        System.err.println("Digite os valores dos lados do triangulo Y:");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();
        areaTrianguloY = y.area();
        System.out.printf("Valor da área triangulo X: %.4f%n", areaTrianguloX);
        System.out.printf("Valor da área triangulo Y: %.4f%n", areaTrianguloY);
        HigherArea(areaTrianguloX,areaTrianguloY);
        
        
        sc.close();
    }


    public static void HigherArea(double areaX,double areaY){
        if(areaX > areaY){
            System.out.println("Larger Area: X");
        }else {
            System.out.println("Larger Area: Y");
        }
    }
}
