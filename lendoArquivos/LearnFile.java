package lendoArquivos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LearnFile {
    public static void main(String[] args) {
        
        File file = new File("C:\\Users\\leand\\OneDrive\\Desktop\\teste.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());

            }
        }catch(IOException e){
            System.out.println("Error: " + e);
        }finally{
            if(sc != null){
                sc.close();
            }
        }
        
    }
}
