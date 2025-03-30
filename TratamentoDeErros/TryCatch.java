package TratamentoDeErros;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        
        metodo1();        
        System.out.println("FIM DO PROGRAMA");
        
    }
    public static void metodo1(){
        metodo2();
    }
    public static void  metodo2(){
        Scanner sc = new Scanner(System.in);
        
        try{
            String[] vetor = sc.nextLine().split(" ");
            int posicao = sc.nextInt();
            System.out.println(vetor[posicao]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("posição inválida");
            e.printStackTrace();
        }catch(InputMismatchException e){
            System.out.println("tipo de input incorreto");
        }
        sc.close();
    }
}
