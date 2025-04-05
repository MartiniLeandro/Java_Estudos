package lendoArquivos;

import java.io.File;
import java.util.Scanner;

public class ManipulandoPastas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o caminho da pasta");
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        File[] pastas = path.listFiles(File::isFile);
        System.out.println(pastas);
        for (File file : pastas) {
            System.out.println(file);
        }

        boolean success = new File(strPath + "\\pastaTeste").mkdir();
        System.out.println(success);
        
        
        sc.close();
    }
}
