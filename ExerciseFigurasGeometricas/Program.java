package ExerciseFigurasGeometricas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Números de formas geométricas: ");
        int n = sc.nextInt();
        List<Formato> formasGeometricas = new ArrayList<>();
        for(int i = 0; i < n; i++){
            System.out.println("DADOS FORMATO #" + (i+1));
            System.out.print("Retangulo ou Circulo (r/c): ");
            Character retanguloCirculo = sc.next().charAt(0);
            System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
            String cor = sc.next();
            if(retanguloCirculo == 'r'){
                System.out.print("Altura: ");
                Double altura = sc.nextDouble();
                System.out.print("Largura: ");
                Double largura = sc.nextDouble();
                Formato forma = new Retangulo(Cores.valueOf(cor), altura, largura);
                formasGeometricas.add(forma);
            }else if(retanguloCirculo == 'c'){
                System.out.print("Raio: ");
                Double raio = sc.nextDouble();
                Formato forma = new Circulo(Cores.valueOf(cor), raio);
                formasGeometricas.add(forma);
            }
            
        }

        System.out.println("AREA DOS FORMATOS: ");
        for (Formato formato : formasGeometricas) {
            System.out.printf("%.2f%n", formato.area());
        }
        
        sc.close();
    }
}