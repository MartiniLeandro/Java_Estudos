package src.application;
import java.util.Scanner;

public class ExTriangleNoPOO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double lado1TrianguloX,lado2TrianguloX,lado3TrianguloX,areaTrianguloX,lado1TrianguloY,lado2TrianguloY,lado3TrianguloY, areaTrianguloY;
        System.err.println("Digite os valores dos lados do triangulo X:");
        lado1TrianguloX = sc.nextDouble();
        lado2TrianguloX = sc.nextDouble();
        lado3TrianguloX = sc.nextDouble();
        areaTrianguloX = CalculateArea(lado1TrianguloX,lado2TrianguloX,lado3TrianguloX);
        System.err.println("Digite os valores dos lados do triangulo Y:");
        lado1TrianguloY = sc.nextDouble();
        lado2TrianguloY = sc.nextDouble();
        lado3TrianguloY = sc.nextDouble();
        areaTrianguloY = CalculateArea(lado1TrianguloY, lado2TrianguloY, lado3TrianguloY);
        System.out.printf("Valor da área triangulo X: %.4f%n", areaTrianguloX);
        System.out.printf("Valor da área triangulo Y: %.4f%n", areaTrianguloY);
        HigherArea(areaTrianguloX,areaTrianguloY);
        
        
        sc.close();
    }

    public static double CalculateArea(double l1,double l2,double l3){
        double p = (l1 + l2 + l3) / 2;
        double areaSimple = p*(p-l1)*(p-l2)*(p-l3);
        double area = Math.sqrt(areaSimple);
        return area;
    }

    public static void HigherArea(double areaX,double areaY){
        if(areaX > areaY){
            System.out.println("Larger Area: X");
        }else {
            System.out.println("Larger Area: Y");
        }
    }
}
