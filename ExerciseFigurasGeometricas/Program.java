package ExerciseFigurasGeometricas;

import java.util.Scanner;

import ExerciseFigurasGeometricas.services.FormatoService;

public class Program{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FormatoService service = new FormatoService();
        
        System.out.print("Números de formas geométricas: ");
        int n = sc.nextInt();
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
                service.CadastroRetangulo(altura, largura, Cores.valueOf(cor));
            }else if(retanguloCirculo == 'c'){
                System.out.print("Raio: ");
                Double raio = sc.nextDouble();
                service.CadastroCirculo(raio, Cores.valueOf(cor));
            }
            
        }

        System.out.println("AREA DOS FORMATOS: ");
        service.AreaFormasGeometricas();
        sc.close();
    }
}