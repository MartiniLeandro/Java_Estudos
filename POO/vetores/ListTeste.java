package POO.vetores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTeste {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Leandro");
        list.add("Martini");
        list.add("Almeida");
        list.add("de Oliveira");
        list.add(2, "Maria");
        
        list.remove(1);
        list.remove("Maria");
        list.removeIf(x -> x.charAt(0) == 'L');
        for(String nome : list){
            System.out.println(nome);
        }
        System.out.println(list.indexOf("de Oliveira")); 
        System.out.println(list.indexOf("Leandro")); 
        List<String> resultado = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
        for(String nome : resultado){
            System.out.println(nome);
        }

    }
}
