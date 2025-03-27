package ExerciseContribuintes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Numero de contribuintes: ");
        int n = sc.nextInt();
        List<Pessoa> contribuintes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            System.out.print("Individual ou Empresa (i/c): ");
            Character caractere = sc.next().charAt(0);
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Renda Anual: ");
            Double rendaAnual = sc.nextDouble();
            if(caractere == 'i'){
                System.out.print("Gastos com saude: ");
                Double gastosSaude = sc.nextDouble();
                contribuintes.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            }else{
                System.out.print("Numero de funcionários: ");
                Integer numeroFuncionarios = sc.nextInt();
                contribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }

        }
        
        System.out.println("VALOR IMPOSTO");
        for (Pessoa pessoa : contribuintes) {
            System.out.printf("%S: $ %.2f%n", pessoa.getNome(), pessoa.valorImposto());
        }
        sc.close();
    }
}
