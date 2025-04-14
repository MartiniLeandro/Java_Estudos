package POO;

import java.util.Arrays;
import java.util.List;

public class TipoCoringa {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5,2,10);
        printList(numbers);
    }

    public static void printList(List<?> list){
        //list.add(3); NÃO PODE ADICIONAR DADOS NA LIST<?>
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
