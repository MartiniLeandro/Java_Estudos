package ExerciseSalario.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ExerciseSalario.entities.Freelancer;
import ExerciseSalario.entities.FuncionarioFixo;

public class QuestionarioService {
    private List<FuncionarioFixo> funcionariosFixos = new ArrayList<>();
    private List<Freelancer> freelancers = new ArrayList<>();

    public void QuestionarioTrabalhadores(Scanner sc) {

        System.out.println("==== FUNCIONÁRIOS ====");
        System.out.print("Quantos funcionários você deseja cadastrar: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpa o \n depois do nextInt

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Funcionário #" + (i + 1) + " ---");

            System.out.print("Nome do Funcionário: ");
            String nome = sc.nextLine();

            System.out.print("CPF do Funcionário: ");
            Integer cpf = sc.nextInt();
            sc.nextLine(); // limpa o \n depois do nextInt

            System.out.print("Funcionário Fixo ou Freela (f/l): ");
            String entrada = sc.nextLine();
            while (entrada.isEmpty()) {
                System.out.print("Entrada inválida. Digite F ou f: ");
                entrada = sc.nextLine();
            }
            char fixoFreela = entrada.charAt(0);

            if (fixoFreela == 'f') {
                System.out.print("Valor fixo de salário: ");
                Double salarioFixo = sc.nextDouble();
                sc.nextLine(); // limpa o \n depois do nextDouble
                FuncionarioFixo funcionarioFixo = new FuncionarioFixo(salarioFixo, nome, cpf);
                funcionariosFixos.add(funcionarioFixo);
            } else {
                System.out.print("Horas trabalhadas: ");
                Integer horasTrabalhadas = sc.nextInt();
                sc.nextLine(); // limpa o \n depois do nextInt
                Freelancer freelancer = new Freelancer(nome, cpf, horasTrabalhadas);
                freelancers.add(freelancer);
            }
        }
    }

    public List<FuncionarioFixo> getFuncionariosFixos() {
        return this.funcionariosFixos;
    }

    public List<Freelancer> getFreelancers() {
        return this.freelancers;
    }
}
