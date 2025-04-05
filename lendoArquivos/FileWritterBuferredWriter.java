package lendoArquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritterBuferredWriter {
    public static void main(String[] args) {
        
        String[] linhas = new String[] {"Bom Dia!!!", "Boa Tarde!!!", "Boa Noite!!!"};
        String path = "C:\\Users\\Leandro Martini\\Desktop\\teste2.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
