package POO;

import java.util.Scanner;

public class Vetores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Matriz de ordem: ");
        int n = sc.nextInt();
        int[][] matriz = new int[n][n];
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriz[i][j] = sc.nextInt();
            }
        }
        System.out.print("Main diagonal: ");
        for(int i = 0; i < n; i++ ){
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println();
        int contador = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matriz[i][j] < 0){
                    contador++;
                }
            }
        }
        System.out.println("Negative numbers: " + contador);
        sc.close();
    }
}
