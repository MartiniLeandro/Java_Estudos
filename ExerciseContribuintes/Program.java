package ExerciseContribuintes;


import java.util.Scanner;

import ExerciseContribuintes.services.CadastroService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroService service = new CadastroService();
        
        System.out.print("Numero de contribuintes: ");
        int n = sc.nextInt();
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
                service.adicionarPessoaFisica(nome, rendaAnual, gastosSaude);
            }else{
                System.out.print("Numero de funcionários: ");
                Integer numeroFuncionarios = sc.nextInt();
                service.adicionarPessoaJuridica(nome, rendaAnual, numeroFuncionarios);
            }

        }
        
        System.out.println("VALOR IMPOSTO");
        service.exibirImpostos();
        sc.close();
    }
}
