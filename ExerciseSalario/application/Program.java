package ExerciseSalario.application;

import java.util.Scanner;

import ExerciseSalario.services.FolhaPagamentoService;
import ExerciseSalario.services.QuestionarioService;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuestionarioService questionarioService = new QuestionarioService();
        FolhaPagamentoService folhaPagamentoService = new FolhaPagamentoService();
        questionarioService.QuestionarioTrabalhadores(sc);
        folhaPagamentoService.exibirPagamentos(questionarioService.getFuncionariosFixos(), questionarioService.getFreelancers());

        sc.close();
    }
}
