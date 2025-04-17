package ExercisesTipoCoringa.ex5;

import java.util.ArrayList;
import java.util.List;

public class AddNumber {
    public static void addNumbers(List<? super Integer> list){
        list.add(10);
        list.add(20);
        list.add(30);
        for (Object object : list) {
            System.out.println(object);
        }

    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        addNumbers(list);
    }
}
