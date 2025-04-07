package ExerciseFuncionarios.services;

import java.util.ArrayList;
import java.util.List;

import ExerciseFuncionarios.Funcionario;
import ExerciseFuncionarios.FuncionarioTerceirizado;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastroFuncionario(String nome, Integer horas, Double valorPorHora){
        Funcionario funcionario = new Funcionario(nome, horas, valorPorHora);
        funcionarios.add(funcionario);
    }
    public void cadastroFuncionarioTerceirizado(String nome, Integer horas, Double valorPorHora, Double valorAdicional){
        Funcionario funcionario = new FuncionarioTerceirizado(nome, horas, valorPorHora, valorAdicional);
        funcionarios.add(funcionario);
    }
    public void totalPagamento(){
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - " + funcionario.pagamento());   
        }
    }
}
