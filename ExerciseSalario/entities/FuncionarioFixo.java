package ExerciseSalario.entities;

import ExerciseSalario.interfaces.Funcionario;

public class FuncionarioFixo implements Funcionario{
    private Double salarioFixo;
    private String nome;
    private Integer cpf;


    public FuncionarioFixo(){super();};
    public FuncionarioFixo(Double salarioMensal, String nome, Integer cpf){
        this.salarioFixo = salarioMensal;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Double getSalarioMensal(){
        return this.salarioFixo;
    }
    public void setSalarioMensal(Double salarioMensal){
        this.salarioFixo = salarioMensal;
    }

    public Double calculoSalario(){
        return this.salarioFixo;
    }
    public String getNome(){
        return this.nome;
    }
    public Integer getCpf(){
        return this.cpf;
    }
}
