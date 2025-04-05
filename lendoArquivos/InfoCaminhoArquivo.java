package lendoArquivos;

import java.io.File;
import java.util.Scanner;

public class InfoCaminhoArquivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o caminho do arquivo");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        System.out.println("Get Name: " + path.getName());
        System.out.println("Get Parent: " + path.getParent());
        System.out.println("Get Path: " + path.getPath());
        
        sc.close();
    }
}
