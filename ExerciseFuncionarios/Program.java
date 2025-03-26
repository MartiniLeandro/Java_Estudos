package ExerciseFuncionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Numero de funcionários: ");
        Integer n = sc.nextInt();
        List<Funcionario> funcionarios = new ArrayList<>();
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
                Funcionario funcionarioTerceirizado = new FuncionarioTerceirizado(nome, horas, valorHora, valorAdicional);
                funcionarios.add(funcionarioTerceirizado);

            }else {
                funcionarios.add(new Funcionario(nome, horas, valorHora));
            }
        }

        System.out.println("PAGAMENTOS");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - " + funcionario.pagamento());
        }


        sc.close();
    }

}
