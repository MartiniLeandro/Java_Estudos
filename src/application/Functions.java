package src.application;
import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite três números: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        
        int higher = functionMax(num1,num2,num3);
        ShowResult(higher);
        sc.close();
    }

    public static int functionMax(int n1,int n2,int n3){
        int max;
        if(n1 > n2 && n1 > n3){
            max = n1;
        }else if (n2 > n3){
            max = n2;
        }else {
            max = n3;
        }
        return max;
    }

    public static void ShowResult(int high){
        System.out.println("Higher: " + high);
    }
}
