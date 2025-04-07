package ExerciseContribuintes.services;

import java.util.ArrayList;
import java.util.List;

import ExerciseContribuintes.Pessoa;
import ExerciseContribuintes.PessoaFisica;
import ExerciseContribuintes.PessoaJuridica;

public class CadastroService {
    private List<Pessoa> contribuintes = new ArrayList<>();

    public void adicionarPessoaFisica(String nome, Double rendaAnual, Double gastosSaude){
        PessoaFisica pf = new PessoaFisica(nome, rendaAnual, gastosSaude);
        contribuintes.add(pf);
    }
    public void adicionarPessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios){
        PessoaJuridica pj = new PessoaJuridica(nome, rendaAnual, numeroFuncionarios);
        contribuintes.add(pj);
    }

    public void exibirImpostos(){
        System.out.println("\nVALOR IMPOSTO:");
        for (Pessoa p : contribuintes) {
            System.out.printf("%s: $ %.2f%n", p.getNome(), p.valorImposto());
        }
    }
}
