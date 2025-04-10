package ExerciseGenerics;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintService<String> pr = new PrintService<>();
        
        System.out.print("Quantos valores? ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            pr.addValue(sc.next());
        }


        System.out.println("First: " + pr.first());
        pr.print();

        
        sc.close();
    }
        
}
