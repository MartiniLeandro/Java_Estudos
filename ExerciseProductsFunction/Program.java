package ExerciseProductsFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Program {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Digite o path do arquivo: ");
        String path = sc.next();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line = bf.readLine();
            while(line != null){
               String[] files = line.split(",");
               products.add(new Product(files[0], Double.parseDouble(files[1])));

               line = bf.readLine();
            }
        }catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }

        double media = products.stream().map(p -> p.getPreco()).reduce(0.0, (x,y) -> x + y) / products.size();
        System.out.println("MÉDIA DE PREÇOS: " + media);
        List<String> productsCheap = products.stream().filter(x -> x.getPreco() < media).map(x -> x.getNome()).collect(Collectors.toList());
        productsCheap.forEach(System.out::println);
        sc.close();
    }
}
