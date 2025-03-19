package POO;

import java.util.Scanner;

public class ExercicioVetores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de linhas: ");
        int linhas = sc.nextInt();
        System.out.print("Numero de colunas: ");
        int colunas = sc.nextInt();
        int[][] matriz = new int[linhas][colunas];
        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                matriz[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }
        
        
        sc.close();
    }
}
