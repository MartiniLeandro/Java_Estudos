package ExercisesAulas.generiscDelimitados2;

import java.util.List;

public class Comparador {
    public static <T extends Comparable<T>>T maxIdade(List<T> list){
        T maior = list.get(0);
        for (T pessoa : list) {
            if(pessoa.compareTo(maior) > 0){
                maior = pessoa;
            }
        }

        return maior;
    }
}
