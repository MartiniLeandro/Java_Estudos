package ExerciseGenerics.ex1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintService<String> pr = new PrintService<>();
        PrintService<Integer> pr2 = new PrintService<>();
        
        System.out.print("Quantos valores? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            pr.addValue(sc.next());
            pr2.addValue(sc.nextInt());;
        }


        System.out.println("First: " + pr.first());
        System.out.println("First: " + pr2.first());
        pr.print();
        pr2.print();

        
        sc.close();
    }
        
}
