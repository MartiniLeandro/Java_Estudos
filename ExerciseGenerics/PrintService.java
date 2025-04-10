package ExerciseGenerics;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T>{
    private List<T> list = new ArrayList<>();


    public void addValue(T value){
        list.add(value);
    }
    public T first(){
        if(list.isEmpty()){
            System.out.println("LISTA VAZIA");
        }
        return list.get(0);
    }
    public void print(){
        System.out.print("[ ");
        for (T t : list) {
            System.out.print(t + ", ");
        }
        System.out.print("]");
    }
    

    
}
