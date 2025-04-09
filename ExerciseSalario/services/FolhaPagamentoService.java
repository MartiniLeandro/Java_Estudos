package ExerciseSalario.services;


import java.util.List;

import ExerciseSalario.entities.Freelancer;
import ExerciseSalario.entities.FuncionarioFixo;

public class FolhaPagamentoService {
    public void exibirPagamentos(List<FuncionarioFixo> funcionariosFixos, List<Freelancer> freelancers){
        System.out.println(" ==== FUNCIONÁRIOS ====");
        System.out.println("Funcionários fixos: ");
        for (FuncionarioFixo fixos : funcionariosFixos) {
            fixos.calculoSalario();
            System.out.println("Nome: " + fixos.getNome() + ", CPF: " + fixos.getCpf() + ", Salário: " + fixos.calculoSalario());
        }
        System.out.println("Funcionários Freelancer: ");
        for (Freelancer freelancer : freelancers) {
            freelancer.calculoSalario();
            System.out.println("Nome: " + freelancer.getNome() + ", CPF: " + freelancer.getCpf() + ", Salário: " + freelancer.calculoSalario());
        }
    }
}
