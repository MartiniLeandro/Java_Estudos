package Exceptions;

import java.io.File;
import java.io.IOException;

//Exceção CHECKED a IDE obriga fazer um tratamento de erro, se não, não é possível rodar o arquivo
public class Exception {
    public static void main(String[] args) {
        CriarArquivo();
    }

    public static void CriarArquivo(){
        File file = new File("src/arquivo\\teste.txt");
        try{
            boolean criado = file.createNewFile();
            System.out.println("Arquivo criado com sucesso " + criado);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
