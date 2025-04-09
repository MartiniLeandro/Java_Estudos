package ExerciseSalario.entities;

import ExerciseSalario.interfaces.Funcionario;

public class Freelancer implements Funcionario{
    private Integer horasTrabalhadas;
    private String nome;
    private Integer cpf;

    public Freelancer(){super();};
    public Freelancer(String nome, Integer cpf, Integer horasTrabalhadas){
        this.nome = nome;
        this.cpf = cpf;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Integer getHorasTrabalhadas(){
        return this.horasTrabalhadas;
    }
    public void setHorasTrabalhadas(Integer horasTrabalhadas){
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getNome(){
        return this.nome;
    }
    public Integer getCpf(){
        return this.cpf;
    }
    public Double calculoSalario(){
        Double valorHora = 50.0;
        Double salario = valorHora * this.horasTrabalhadas;
        return salario;
    }

}
