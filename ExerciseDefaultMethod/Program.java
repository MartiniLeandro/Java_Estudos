package ExerciseDefaultMethod;

import java.util.Scanner;

import ExerciseDefaultMethod.service.JurosBrasilService;
import ExerciseDefaultMethod.service.JurosService;
import ExerciseDefaultMethod.service.JurosUsaService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        double valor = sc.nextDouble();
        System.out.print("Meses: ");
        int meses = sc.nextInt();

        JurosService jurosBR = new JurosBrasilService(2.0);
        JurosService jurosUSA = new JurosUsaService(1.0);
        double pagamentoUSA = jurosUSA.pagamento(valor, meses);
        double pagamentoBR = jurosBR.pagamento(valor, meses);

        System.out.println("Pagamento após " + meses + " meses:");
        System.out.println(String.format("%.2f", pagamentoBR));
        System.out.println(String.format("%.2f", pagamentoUSA));


        sc.close();
    }
}
