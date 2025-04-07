package ExerciseFuncionarios;


import java.util.Scanner;

import ExerciseFuncionarios.services.FuncionarioService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionarioService service = new FuncionarioService();
        
        System.out.print("Numero de funcionários: ");
        Integer n = sc.nextInt();
    
        for(int i = 0; i < n; i++){
            System.out.println("DADOS FUNCIONÁRIO #" + (i+1));
            System.out.print("Terceirizado(y/n)?");
            Character yesOrNo = sc.next().charAt(0);
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Horas: ");
            Integer horas = sc.nextInt();
            System.out.print("Valor por hora: ");
            Double valorHora = sc.nextDouble();
            if(yesOrNo == 'y'){
                System.out.print("Valor adicional: ");
                Double valorAdicional = sc.nextDouble();
                service.cadastroFuncionarioTerceirizado(nome, horas, valorHora, valorAdicional);    

            }else {
               service.cadastroFuncionario(nome, horas, valorHora);
            }
        }

        System.out.println("PAGAMENTOS");
        service.totalPagamento();

        sc.close();
    }

}
