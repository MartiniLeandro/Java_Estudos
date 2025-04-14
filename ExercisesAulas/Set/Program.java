package ExercisesAulas.Set;

import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("TV");
        set.add("Tablet");
        set.add("Notebook");

        set.remove("Tablet");
        set.removeIf(x -> x.length() >= 3);

        for (String string : set) {
            System.out.println(string);
        }
    }
}
