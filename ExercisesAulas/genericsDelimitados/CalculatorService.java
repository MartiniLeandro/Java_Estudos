package ExercisesAulas.genericsDelimitados;

import java.util.List;

public class CalculatorService {
    
    public static <T extends Comparable<T>>T max(List<T> list){
        T max = list.get(0);
        for (T item : list) {
            if(item.compareTo(max) > 0){
                max = item;
            }
        }
        return max;
    }
}
