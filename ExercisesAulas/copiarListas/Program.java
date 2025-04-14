package ExercisesAulas.copiarListas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1,2,3,4);
        List<Double> myDouble = Arrays.asList(3.4,5.6,8.1);
        List<Object> myObjs = new ArrayList<>();

        copy(myInts,myObjs);
        printList(myObjs);
        copy(myDouble,myObjs);
        printList(myObjs);
    
    }

    public static void copy(List<? extends Number> list1, List<? super Number > list2){
        for (Number number : list1) {
            list2.add(number);
        }

    }

    public static void printList(List<?> list){
        System.out.println(list + " ");
    }
}
